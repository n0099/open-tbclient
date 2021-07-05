package com.yy.hiidostatis.message;

import com.yy.hiidostatis.api.StatisContent;
/* loaded from: classes8.dex */
public interface Packer {

    /* loaded from: classes8.dex */
    public interface OnSavedListener {
        void onSaved(boolean z);
    }

    boolean addMessage(StatisContent statisContent);

    boolean addMessage(StatisContent statisContent, OnSavedListener onSavedListener);

    void onInited(boolean z);
}
