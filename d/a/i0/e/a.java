package d.a.i0.e;

import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f48427f = String.valueOf(Integer.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final String f48428g = String.valueOf(2147483646);

    /* renamed from: a  reason: collision with root package name */
    public String f48429a;

    /* renamed from: b  reason: collision with root package name */
    public String f48430b;

    /* renamed from: c  reason: collision with root package name */
    public int f48431c;

    /* renamed from: d  reason: collision with root package name */
    public MediaFileInfo f48432d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaFileInfo> f48433e;

    public void a() {
        this.f48431c++;
    }

    public String b() {
        return this.f48429a;
    }

    public int c() {
        return this.f48431c;
    }

    public List<MediaFileInfo> d() {
        return this.f48433e;
    }

    public ImageFileInfo e() {
        MediaFileInfo mediaFileInfo = this.f48432d;
        if (mediaFileInfo instanceof ImageFileInfo) {
            return (ImageFileInfo) mediaFileInfo;
        }
        return null;
    }

    public MediaFileInfo f() {
        return this.f48432d;
    }

    public String g() {
        return this.f48430b;
    }

    public void h(String str) {
        this.f48429a = str;
    }

    public void i(String str) {
        this.f48431c = d.a.c.e.m.b.d(str, 0);
    }

    public void j(List<MediaFileInfo> list) {
        this.f48433e = list;
    }

    public void k(MediaFileInfo mediaFileInfo) {
        this.f48432d = mediaFileInfo;
    }

    public void l(String str) {
        this.f48430b = str;
    }
}
