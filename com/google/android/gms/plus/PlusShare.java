package com.google.android.gms.plus;

import android.content.Intent;
/* loaded from: classes.dex */
public final class PlusShare {

    /* loaded from: classes.dex */
    public class Builder {
        private final Intent a;

        public Builder() {
            this("android.intent.action.SEND");
        }

        protected Builder(String str) {
            this.a = new Intent().setAction(str);
        }
    }

    protected PlusShare() {
        throw new AssertionError();
    }
}
