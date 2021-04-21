package d.b.j0.q0.f2.a;

import com.squareup.wire.Message;
import d.b.i0.g0.b.h;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.ZoneRight.DataRes;
import tbclient.ZoneRight.Toast;
import tbclient.ZoneRight.ZoneRightResIdl;
/* loaded from: classes4.dex */
public class b implements h {

    /* renamed from: e  reason: collision with root package name */
    public boolean f59621e;

    /* renamed from: f  reason: collision with root package name */
    public int f59622f;

    /* renamed from: g  reason: collision with root package name */
    public String f59623g;

    /* renamed from: h  reason: collision with root package name */
    public int f59624h;
    public String i;

    @Override // d.b.i0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.b.i0.g0.b.h
    public void initByProtobuf(Message message) {
        if (message instanceof ZoneRightResIdl) {
            ZoneRightResIdl zoneRightResIdl = (ZoneRightResIdl) message;
            Error error = zoneRightResIdl.error;
            if (error != null) {
                this.f59622f = error.errorno.intValue();
                this.f59623g = zoneRightResIdl.error.usermsg;
            }
            DataRes dataRes = zoneRightResIdl.data;
            if (dataRes != null) {
                this.f59621e = dataRes.has_right.intValue() == 1;
                Toast toast = zoneRightResIdl.data.toast;
                if (toast != null) {
                    this.f59624h = toast.type.intValue();
                    this.i = zoneRightResIdl.data.toast.content;
                }
            }
        }
    }
}
