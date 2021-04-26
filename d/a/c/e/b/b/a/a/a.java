package d.a.c.e.b.b.a.a;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.squareup.wire.Message;
import d.a.c.e.b.b.a.c.c;
import d.a.c.e.b.b.a.c.f;
import d.a.c.e.b.b.a.c.g;
import d.a.c.e.b.b.a.c.h;
import d.a.c.e.b.b.a.e.d;
import d.a.c.e.b.b.a.e.e;
import java.util.Map;
import org.json.JSONObject;
import org.w3c.dom.Element;
/* loaded from: classes.dex */
public class a implements b {
    private boolean fillByDataSource(c cVar) {
        boolean a2 = e.a(cVar, this);
        onFinishSourceToObject(a2);
        return a2;
    }

    private boolean fillInDataSource(c cVar) {
        onPreObjectToSource();
        return d.a(this, cVar);
    }

    public boolean fillByBundle(Bundle bundle) {
        return fillByDataSource(new d.a.c.e.b.b.a.c.a(bundle));
    }

    public boolean fillByCursorObject(Cursor cursor) {
        return fillByDataSource(new d.a.c.e.b.b.a.c.b(cursor));
    }

    public boolean fillByIntent(Intent intent) {
        return fillByDataSource(new d.a.c.e.b.b.a.c.d(intent));
    }

    public boolean fillByJsonObject(JSONObject jSONObject) {
        return fillByDataSource(new d.a.c.e.b.b.a.c.e(jSONObject));
    }

    public boolean fillByMap(Map<String, Object> map) {
        return fillByDataSource(new f(map));
    }

    public boolean fillByProtobufObject(Message message) {
        return fillByDataSource(new g(message));
    }

    public boolean fillByXmlObject(Element element) {
        return fillByDataSource(new h(element));
    }

    public boolean fillInBundle(Bundle bundle) {
        return fillInDataSource(new d.a.c.e.b.b.a.c.a(bundle));
    }

    public boolean fillInCursorObject(ContentValues contentValues) {
        return fillInDataSource(new d.a.c.e.b.b.a.c.b(contentValues));
    }

    public boolean fillInIntent(Intent intent) {
        return fillInDataSource(new d.a.c.e.b.b.a.c.d(intent));
    }

    public boolean fillInJsonObject(JSONObject jSONObject) {
        return fillInDataSource(new d.a.c.e.b.b.a.c.e(jSONObject));
    }

    public boolean fillInMap(Map<String, Object> map) {
        return fillInDataSource(new f(map));
    }

    public boolean fillInProtobufObject(Message message) {
        return fillInDataSource(new g(message));
    }

    public boolean fillInXmlObject(Element element) {
        return fillInDataSource(new h(element));
    }

    public void onFinishSourceToObject(boolean z) {
    }

    public void onPreObjectToSource() {
    }
}
