package d.l.a.g;

import com.opensource.svgaplayer.proto.AudioEntity;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f70230a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70231b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f70232c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f70233d;

    public a(AudioEntity audioEntity) {
        String str = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.f70230a = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.f70231b = num2 != null ? num2.intValue() : 0;
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
        return this.f70231b;
    }

    public final Integer b() {
        return this.f70233d;
    }

    public final Integer c() {
        return this.f70232c;
    }

    public final int d() {
        return this.f70230a;
    }

    public final void e(Integer num) {
        this.f70233d = num;
    }

    public final void f(Integer num) {
        this.f70232c = num;
    }
}
