package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public abstract class b<T, F> implements m {
    public abstract void a(master.flame.danmaku.danmaku.model.android.b bVar);

    public abstract void a(d dVar, T t, float f, float f2, boolean z);

    public abstract master.flame.danmaku.danmaku.model.android.b ehv();

    public abstract void setExtraData(T t);

    public abstract T tX();

    @Override // master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return false;
    }
}
