package d.l.a.g;

import com.opensource.svgaplayer.proto.AudioEntity;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f66246a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66247b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f66248c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f66249d;

    public a(AudioEntity audioEntity) {
        String str = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.f66246a = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.f66247b = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        if (num3 != null) {
            num3.intValue();
        }
        Integer num4 = audioEntity.totalTime;
        if (num4 != null) {
            num4.intValue();
        }
    }

    public final int a() {
        return this.f66247b;
    }

    public final Integer b() {
        return this.f66249d;
    }

    public final Integer c() {
        return this.f66248c;
    }

    public final int d() {
        return this.f66246a;
    }

    public final void e(Integer num) {
        this.f66249d = num;
    }

    public final void f(Integer num) {
        this.f66248c = num;
    }
}
