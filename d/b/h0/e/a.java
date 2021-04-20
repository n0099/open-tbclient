package d.b.h0.e;

import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f50513f = String.valueOf(Integer.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final String f50514g = String.valueOf(2147483646);

    /* renamed from: a  reason: collision with root package name */
    public String f50515a;

    /* renamed from: b  reason: collision with root package name */
    public String f50516b;

    /* renamed from: c  reason: collision with root package name */
    public int f50517c;

    /* renamed from: d  reason: collision with root package name */
    public MediaFileInfo f50518d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaFileInfo> f50519e;

    public void a() {
        this.f50517c++;
    }

    public String b() {
        return this.f50515a;
    }

    public int c() {
        return this.f50517c;
    }

    public List<MediaFileInfo> d() {
        return this.f50519e;
    }

    public ImageFileInfo e() {
        MediaFileInfo mediaFileInfo = this.f50518d;
        if (mediaFileInfo instanceof ImageFileInfo) {
            return (ImageFileInfo) mediaFileInfo;
        }
        return null;
    }

    public MediaFileInfo f() {
        return this.f50518d;
    }

    public String g() {
        return this.f50516b;
    }

    public void h(String str) {
        this.f50515a = str;
    }

    public void i(String str) {
        this.f50517c = d.b.c.e.m.b.d(str, 0);
    }

    public void j(List<MediaFileInfo> list) {
        this.f50519e = list;
    }

    public void k(MediaFileInfo mediaFileInfo) {
        this.f50518d = mediaFileInfo;
    }

    public void l(String str) {
        this.f50516b = str;
    }
}
