package d.a.m0.e;

import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f52973f = String.valueOf(Integer.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final String f52974g = String.valueOf(2147483646);

    /* renamed from: a  reason: collision with root package name */
    public String f52975a;

    /* renamed from: b  reason: collision with root package name */
    public String f52976b;

    /* renamed from: c  reason: collision with root package name */
    public int f52977c;

    /* renamed from: d  reason: collision with root package name */
    public MediaFileInfo f52978d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaFileInfo> f52979e;

    public void a() {
        this.f52977c++;
    }

    public String b() {
        return this.f52975a;
    }

    public int c() {
        return this.f52977c;
    }

    public List<MediaFileInfo> d() {
        return this.f52979e;
    }

    public ImageFileInfo e() {
        MediaFileInfo mediaFileInfo = this.f52978d;
        if (mediaFileInfo instanceof ImageFileInfo) {
            return (ImageFileInfo) mediaFileInfo;
        }
        return null;
    }

    public MediaFileInfo f() {
        return this.f52978d;
    }

    public String g() {
        return this.f52976b;
    }

    public void h(String str) {
        this.f52975a = str;
    }

    public void i(String str) {
        this.f52977c = d.a.c.e.m.b.d(str, 0);
    }

    public void j(List<MediaFileInfo> list) {
        this.f52979e = list;
    }

    public void k(MediaFileInfo mediaFileInfo) {
        this.f52978d = mediaFileInfo;
    }

    public void l(String str) {
        this.f52976b = str;
    }
}
