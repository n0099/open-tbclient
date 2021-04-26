package d.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class z implements Cloneable {
    public static final SimpleDateFormat l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* renamed from: e  reason: collision with root package name */
    public long f64413e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public long f64414f;

    /* renamed from: g  reason: collision with root package name */
    public String f64415g;

    /* renamed from: h  reason: collision with root package name */
    public String f64416h;

    /* renamed from: i  reason: collision with root package name */
    public String f64417i;
    public String j;
    public String k;

    public static z b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return a0.f64240e.get(jSONObject.optString("k_cls", "")).clone().h(jSONObject);
        } catch (Throwable th) {
            r0.b(th);
            return null;
        }
    }

    public static String c(long j) {
        return l.format(new Date(j));
    }

    @NonNull
    public abstract z a(@NonNull Cursor cursor);

    public abstract void d(@NonNull ContentValues contentValues);

    public abstract void e(@NonNull JSONObject jSONObject);

    public abstract String[] f();

    public final ContentValues g(@Nullable ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        d(contentValues);
        return contentValues;
    }

    public abstract z h(@NonNull JSONObject jSONObject);

    public abstract JSONObject i();

    public final String j() {
        String[] f2 = f();
        if (f2 != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("create table if not exists ");
            sb.append(k());
            sb.append("(");
            for (int i2 = 0; i2 < f2.length; i2 += 2) {
                sb.append(f2[i2]);
                sb.append(" ");
                sb.append(f2[i2 + 1]);
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return null;
    }

    @NonNull
    public abstract String k();

    @NonNull
    public final JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", k());
            e(jSONObject);
        } catch (JSONException e2) {
            r0.b(e2);
        }
        return jSONObject;
    }

    @NonNull
    public final JSONObject m() {
        try {
            this.k = c(this.f64413e);
            return i();
        } catch (JSONException e2) {
            r0.b(e2);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: n */
    public z clone() {
        try {
            return (z) super.clone();
        } catch (CloneNotSupportedException e2) {
            r0.b(e2);
            return null;
        }
    }

    public String o() {
        return "sid:" + this.f64415g;
    }

    @NonNull
    public String toString() {
        if (r0.f64363b) {
            String k = k();
            if (!getClass().getSimpleName().equalsIgnoreCase(k)) {
                k = k + StringUtil.ARRAY_ELEMENT_SEPARATOR + getClass().getSimpleName();
            }
            String str = this.f64415g;
            String str2 = "-";
            if (str != null) {
                int indexOf = str.indexOf("-");
                if (indexOf >= 0) {
                    str = str.substring(0, indexOf);
                }
                str2 = str;
            }
            return StringUtil.ARRAY_START + k + StringUtil.ARRAY_ELEMENT_SEPARATOR + o() + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f64413e + "}";
        }
        return super.toString();
    }
}
