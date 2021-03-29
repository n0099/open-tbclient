package d.b.h0.e;

import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f50120f = String.valueOf(Integer.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final String f50121g = String.valueOf(2147483646);

    /* renamed from: a  reason: collision with root package name */
    public String f50122a;

    /* renamed from: b  reason: collision with root package name */
    public String f50123b;

    /* renamed from: c  reason: collision with root package name */
    public int f50124c;

    /* renamed from: d  reason: collision with root package name */
    public MediaFileInfo f50125d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaFileInfo> f50126e;

    public void a() {
        this.f50124c++;
    }

    public String b() {
        return this.f50122a;
    }

    public int c() {
        return this.f50124c;
    }

    public List<MediaFileInfo> d() {
        return this.f50126e;
    }

    public ImageFileInfo e() {
        MediaFileInfo mediaFileInfo = this.f50125d;
        if (mediaFileInfo instanceof ImageFileInfo) {
            return (ImageFileInfo) mediaFileInfo;
        }
        return null;
    }

    public MediaFileInfo f() {
        return this.f50125d;
    }

    public String g() {
        return this.f50123b;
    }

    public void h(String str) {
        this.f50122a = str;
    }

    public void i(String str) {
        this.f50124c = d.b.b.e.m.b.d(str, 0);
    }

    public void j(List<MediaFileInfo> list) {
        this.f50126e = list;
    }

    public void k(MediaFileInfo mediaFileInfo) {
        this.f50125d = mediaFileInfo;
    }

    public void l(String str) {
        this.f50123b = str;
    }
}
