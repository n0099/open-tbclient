package d.m.a.g;

import com.opensource.svgaplayer.proto.AudioEntity;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f67387a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67388b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f67389c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f67390d;

    public a(AudioEntity audioEntity) {
        String str = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.f67387a = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.f67388b = num2 != null ? num2.intValue() : 0;
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
        return this.f67388b;
    }

    public final Integer b() {
        return this.f67390d;
    }

    public final Integer c() {
        return this.f67389c;
    }

    public final int d() {
        return this.f67387a;
    }

    public final void e(Integer num) {
        this.f67390d = num;
    }

    public final void f(Integer num) {
        this.f67389c = num;
    }
}
