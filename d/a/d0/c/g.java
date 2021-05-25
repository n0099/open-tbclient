package d.a.d0.c;

import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f39670e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f39671f;

    /* renamed from: h  reason: collision with root package name */
    public String[] f39673h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f39674i;
    public g k;
    public JSONObject m;
    public String n;

    /* renamed from: g  reason: collision with root package name */
    public int f39672g = -1;
    public boolean j = false;
    public boolean l = false;

    static {
        String str = c.b() + "://";
    }

    public g(Uri uri, String str) {
        this.f39670e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f39670e = str;
        this.f39671f = uri;
        this.f39673h = j.c(uri);
        this.f39674i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public g clone() {
        Uri uri = this.f39671f;
        g gVar = new g(uri, this.f39670e, j.c(uri), (HashMap) this.f39674i.clone());
        gVar.k = this;
        gVar.l = this.l;
        gVar.n = this.n;
        return gVar;
    }

    public String c() {
        String path;
        Uri uri = this.f39671f;
        if (uri != null) {
            if (j.d(uri) && (path = this.f39671f.getPath()) != null && path.length() > 1) {
                return this.f39671f.getPath().substring(1);
            }
            return this.f39671f.getHost() + this.f39671f.getPath();
        }
        return "";
    }

    public HashMap<String, String> d() {
        return this.f39674i;
    }

    public String e(boolean z) {
        if (this.f39673h != null) {
            if (z) {
                this.f39672g++;
            }
            int i2 = this.f39672g;
            String[] strArr = this.f39673h;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
            return null;
        }
        return null;
    }

    public Uri f() {
        return this.f39671f;
    }

    public boolean g() {
        return this.j;
    }

    public void h(String str, String str2) {
        Uri uri = this.f39671f;
        if (uri == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f39671f = parse;
        this.f39673h = j.c(parse);
    }

    public void i(boolean z) {
        this.j = z;
    }

    public g(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        this.f39670e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f39671f = uri;
        this.f39670e = str;
        this.f39673h = strArr;
        this.f39674i = hashMap;
    }
}
