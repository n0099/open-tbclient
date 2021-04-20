package d.b.i0.q0.f2.a;

import com.squareup.wire.Message;
import d.b.h0.g0.b.h;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.ZoneRight.DataRes;
import tbclient.ZoneRight.Toast;
import tbclient.ZoneRight.ZoneRightResIdl;
/* loaded from: classes4.dex */
public class b implements h {

    /* renamed from: e  reason: collision with root package name */
    public boolean f59200e;

    /* renamed from: f  reason: collision with root package name */
    public int f59201f;

    /* renamed from: g  reason: collision with root package name */
    public String f59202g;

    /* renamed from: h  reason: collision with root package name */
    public int f59203h;
    public String i;

    @Override // d.b.h0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.b.h0.g0.b.h
    public void initByProtobuf(Message message) {
        if (message instanceof ZoneRightResIdl) {
            ZoneRightResIdl zoneRightResIdl = (ZoneRightResIdl) message;
            Error error = zoneRightResIdl.error;
            if (error != null) {
                this.f59201f = error.errorno.intValue();
                this.f59202g = zoneRightResIdl.error.usermsg;
            }
            DataRes dataRes = zoneRightResIdl.data;
            if (dataRes != null) {
                this.f59200e = dataRes.has_right.intValue() == 1;
                Toast toast = zoneRightResIdl.data.toast;
                if (toast != null) {
                    this.f59203h = toast.type.intValue();
                    this.i = zoneRightResIdl.data.toast.content;
                }
            }
        }
    }
}
