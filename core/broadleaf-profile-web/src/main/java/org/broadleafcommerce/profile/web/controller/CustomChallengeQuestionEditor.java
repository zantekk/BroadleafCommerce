/*
 * Copyright 2008-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.broadleafcommerce.profile.web.controller;

import java.beans.PropertyEditorSupport;

import org.broadleafcommerce.profile.core.domain.ChallengeQuestion;
import org.broadleafcommerce.profile.core.service.ChallengeQuestionService;

public class CustomChallengeQuestionEditor extends PropertyEditorSupport {
    
    private ChallengeQuestionService challengeQuestionService;
    
    public CustomChallengeQuestionEditor(ChallengeQuestionService challengeQuestionService) {
        this.challengeQuestionService = challengeQuestionService;
    }

    @Override
    public String getAsText() {
        ChallengeQuestion question = (ChallengeQuestion) getValue();
        if (question == null) {
            return null;
        } else {
            return question.getId().toString();
        }
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(challengeQuestionService.readChallengeQuestionById((Long.parseLong(text))));
    }

}
