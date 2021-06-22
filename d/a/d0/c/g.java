package d.a.d0.c;

import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f43454e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f43455f;

    /* renamed from: h  reason: collision with root package name */
    public String[] f43457h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f43458i;
    public g k;
    public JSONObject m;
    public String n;

    /* renamed from: g  reason: collision with root package name */
    public int f43456g = -1;
    public boolean j = false;
    public boolean l = false;

    static {
        String str = c.b() + "://";
    }

    public g(Uri uri, String str) {
        this.f43454e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f43454e = str;
        this.f43455f = uri;
        this.f43457h = j.c(uri);
        this.f43458i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public g clone() {
        Uri uri = this.f43455f;
        g gVar = new g(uri, this.f43454e, j.c(uri), (HashMap) this.f43458i.clone());
        gVar.k = this;
        gVar.l = this.l;
        gVar.n = this.n;
        return gVar;
    }

    public String c() {
        String path;
        Uri uri = this.f43455f;
        if (uri != null) {
            if (j.d(uri) && (path = this.f43455f.getPath()) != null && path.length() > 1) {
                return this.f43455f.getPath().substring(1);
            }
            return this.f43455f.getHost() + this.f43455f.getPath();
        }
        return "";
    }

    public HashMap<String, String> d() {
        return this.f43458i;
    }

    public String e(boolean z) {
        if (this.f43457h != null) {
            if (z) {
                this.f43456g++;
            }
            int i2 = this.f43456g;
            String[] strArr = this.f43457h;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
            return null;
        }
        return null;
    }

    public Uri f() {
        return this.f43455f;
    }

    public boolean g() {
        return this.j;
    }

    public void h(String str, String str2) {
        Uri uri = this.f43455f;
        if (uri == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f43455f = parse;
        this.f43457h = j.c(parse);
    }

    public void i(boolean z) {
        this.j = z;
    }

    public g(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        this.f43454e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f43455f = uri;
        this.f43454e = str;
        this.f43457h = strArr;
        this.f43458i = hashMap;
    }
}
