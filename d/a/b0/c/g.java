package d.a.b0.c;

import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f39356e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f39357f;

    /* renamed from: h  reason: collision with root package name */
    public String[] f39359h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f39360i;
    public g k;
    public JSONObject m;
    public String n;

    /* renamed from: g  reason: collision with root package name */
    public int f39358g = -1;
    public boolean j = false;
    public boolean l = false;

    static {
        String str = c.b() + "://";
    }

    public g(Uri uri, String str) {
        this.f39356e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f39356e = str;
        this.f39357f = uri;
        this.f39359h = j.c(uri);
        this.f39360i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public g clone() {
        Uri uri = this.f39357f;
        g gVar = new g(uri, this.f39356e, j.c(uri), (HashMap) this.f39360i.clone());
        gVar.k = this;
        gVar.l = this.l;
        gVar.n = this.n;
        return gVar;
    }

    public String c() {
        String path;
        Uri uri = this.f39357f;
        if (uri != null) {
            if (j.d(uri) && (path = this.f39357f.getPath()) != null && path.length() > 1) {
                return this.f39357f.getPath().substring(1);
            }
            return this.f39357f.getHost() + this.f39357f.getPath();
        }
        return "";
    }

    public HashMap<String, String> d() {
        return this.f39360i;
    }

    public String e(boolean z) {
        if (this.f39359h != null) {
            if (z) {
                this.f39358g++;
            }
            int i2 = this.f39358g;
            String[] strArr = this.f39359h;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
            return null;
        }
        return null;
    }

    public Uri f() {
        return this.f39357f;
    }

    public boolean g() {
        return this.j;
    }

    public void h(String str, String str2) {
        Uri uri = this.f39357f;
        if (uri == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f39357f = parse;
        this.f39359h = j.c(parse);
    }

    public void i(boolean z) {
        this.j = z;
    }

    public g(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        this.f39356e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f39357f = uri;
        this.f39356e = str;
        this.f39359h = strArr;
        this.f39360i = hashMap;
    }
}
