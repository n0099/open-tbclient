package d.b.h0.e;

import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f50119f = String.valueOf(Integer.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final String f50120g = String.valueOf(2147483646);

    /* renamed from: a  reason: collision with root package name */
    public String f50121a;

    /* renamed from: b  reason: collision with root package name */
    public String f50122b;

    /* renamed from: c  reason: collision with root package name */
    public int f50123c;

    /* renamed from: d  reason: collision with root package name */
    public MediaFileInfo f50124d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaFileInfo> f50125e;

    public void a() {
        this.f50123c++;
    }

    public String b() {
        return this.f50121a;
    }

    public int c() {
        return this.f50123c;
    }

    public List<MediaFileInfo> d() {
        return this.f50125e;
    }

    public ImageFileInfo e() {
        MediaFileInfo mediaFileInfo = this.f50124d;
        if (mediaFileInfo instanceof ImageFileInfo) {
            return (ImageFileInfo) mediaFileInfo;
        }
        return null;
    }

    public MediaFileInfo f() {
        return this.f50124d;
    }

    public String g() {
        return this.f50122b;
    }

    public void h(String str) {
        this.f50121a = str;
    }

    public void i(String str) {
        this.f50123c = d.b.b.e.m.b.d(str, 0);
    }

    public void j(List<MediaFileInfo> list) {
        this.f50125e = list;
    }

    public void k(MediaFileInfo mediaFileInfo) {
        this.f50124d = mediaFileInfo;
    }

    public void l(String str) {
        this.f50122b = str;
    }
}
