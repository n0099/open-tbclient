package com.repackage;
/* loaded from: classes5.dex */
public interface bv8 {

    /* loaded from: classes5.dex */
    public interface a {
        float a();

        void b(float f);

        void onFinish();

        void onProgress(float f);
    }

    void a();

    boolean b();

    int getMaxDuration();

    float getProgress();

    int getSlideNum();

    void invalidate();

    void reset();

    void setMaxDuration(int i);

    void setMinDuration(int i);

    void setOnProgressListener(a aVar);

    void setProgress(long j);

    void setShowDeleteLastTip(boolean z);

    void setVisibility(int i);

    void start();

    void stop();
}
