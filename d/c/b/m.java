package d.c.b;

import android.content.Context;
import com.kwai.video.player.KsMediaMeta;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65037e;

    public m(Context context) {
        super(true, true);
        this.f65037e = context;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        j.f(jSONObject, KsMediaMeta.KSM_KEY_LANGUAGE, this.f65037e.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put("timezone", rawOffset);
        j.f(jSONObject, "region", Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        j.f(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
