package d.a.p0.z3.m;
/* loaded from: classes8.dex */
public interface a {

    /* renamed from: d.a.p0.z3.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1878a {
        float a();

        void b(float f2);

        void onFinish();

        void onProgress(float f2);
    }

    void a();

    boolean b();

    int getMaxDuration();

    float getProgress();

    int getSlideNum();

    void invalidate();

    void reset();

    void setMaxDuration(int i2);

    void setMinDuration(int i2);

    void setOnProgressListener(InterfaceC1878a interfaceC1878a);

    void setProgress(long j);

    void setShowDeleteLastTip(boolean z);

    void setVisibility(int i2);

    void start();

    void stop();
}
