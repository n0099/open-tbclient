package d.l.a.g;

import com.opensource.svgaplayer.proto.AudioEntity;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f65715a;

    /* renamed from: b  reason: collision with root package name */
    public final int f65716b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f65717c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f65718d;

    public a(AudioEntity audioEntity) {
        String str = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.f65715a = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.f65716b = num2 != null ? num2.intValue() : 0;
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
        return this.f65716b;
    }

    public final Integer b() {
        return this.f65718d;
    }

    public final Integer c() {
        return this.f65717c;
    }

    public final int d() {
        return this.f65715a;
    }

    public final void e(Integer num) {
        this.f65718d = num;
    }

    public final void f(Integer num) {
        this.f65717c = num;
    }
}
