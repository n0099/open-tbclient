package com.repackage;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public interface u79 {

    /* loaded from: classes7.dex */
    public interface a {
        void onCompletion();

        boolean onError(int i, int i2, Object obj);

        boolean onInfo(int i, int i2, Object obj);
    }

    void release();

    void setListener(a aVar);

    void setSource(ArrayList<String> arrayList);

    void start();
}
