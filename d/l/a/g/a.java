package d.l.a.g;

import com.opensource.svgaplayer.proto.AudioEntity;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f66247a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66248b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f66249c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f66250d;

    public a(AudioEntity audioEntity) {
        String str = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.f66247a = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.f66248b = num2 != null ? num2.intValue() : 0;
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
        return this.f66248b;
    }

    public final Integer b() {
        return this.f66250d;
    }

    public final Integer c() {
        return this.f66249c;
    }

    public final int d() {
        return this.f66247a;
    }

    public final void e(Integer num) {
        this.f66250d = num;
    }

    public final void f(Integer num) {
        this.f66249c = num;
    }
}
