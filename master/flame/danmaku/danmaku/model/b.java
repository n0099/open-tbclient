package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class b<T, F> implements m {
    public abstract void a(master.flame.danmaku.danmaku.model.android.b bVar);

    public abstract void a(d dVar, T t, float f, float f2, boolean z);

    public abstract master.flame.danmaku.danmaku.model.android.b dFh();

    public abstract T rJ();

    public abstract void setExtraData(T t);

    @Override // master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return false;
    }
}
