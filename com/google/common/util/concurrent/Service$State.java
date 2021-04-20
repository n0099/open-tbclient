package com.google.common.util.concurrent;
/* loaded from: classes6.dex */
public enum Service$State {
    NEW { // from class: com.google.common.util.concurrent.Service$State.1
        @Override // com.google.common.util.concurrent.Service$State
        public boolean isTerminal() {
            return false;
        }
    },
    STARTING { // from class: com.google.common.util.concurrent.Service$State.2
        @Override // com.google.common.util.concurrent.Service$State
        public boolean isTerminal() {
            return false;
        }
    },
    RUNNING { // from class: com.google.common.util.concurrent.Service$State.3
        @Override // com.google.common.util.concurrent.Service$State
        public boolean isTerminal() {
            return false;
        }
    },
    STOPPING { // from class: com.google.common.util.concurrent.Service$State.4
        @Override // com.google.common.util.concurrent.Service$State
        public boolean isTerminal() {
            return false;
        }
    },
    TERMINATED { // from class: com.google.common.util.concurrent.Service$State.5
        @Override // com.google.common.util.concurrent.Service$State
        public boolean isTerminal() {
            return true;
        }
    },
    FAILED { // from class: com.google.common.util.concurrent.Service$State.6
        @Override // com.google.common.util.concurrent.Service$State
        public boolean isTerminal() {
            return true;
        }
    };

    public abstract boolean isTerminal();
}
