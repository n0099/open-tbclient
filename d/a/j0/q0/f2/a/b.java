package d.a.j0.q0.f2.a;

import com.squareup.wire.Message;
import d.a.i0.g0.b.h;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.ZoneRight.DataRes;
import tbclient.ZoneRight.Toast;
import tbclient.ZoneRight.ZoneRightResIdl;
/* loaded from: classes4.dex */
public class b implements h {

    /* renamed from: e  reason: collision with root package name */
    public boolean f57679e;

    /* renamed from: f  reason: collision with root package name */
    public int f57680f;

    /* renamed from: g  reason: collision with root package name */
    public String f57681g;

    /* renamed from: h  reason: collision with root package name */
    public int f57682h;

    /* renamed from: i  reason: collision with root package name */
    public String f57683i;

    @Override // d.a.i0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.a.i0.g0.b.h
    public void initByProtobuf(Message message) {
        if (message instanceof ZoneRightResIdl) {
            ZoneRightResIdl zoneRightResIdl = (ZoneRightResIdl) message;
            Error error = zoneRightResIdl.error;
            if (error != null) {
                this.f57680f = error.errorno.intValue();
                this.f57681g = zoneRightResIdl.error.usermsg;
            }
            DataRes dataRes = zoneRightResIdl.data;
            if (dataRes != null) {
                this.f57679e = dataRes.has_right.intValue() == 1;
                Toast toast = zoneRightResIdl.data.toast;
                if (toast != null) {
                    this.f57682h = toast.type.intValue();
                    this.f57683i = zoneRightResIdl.data.toast.content;
                }
            }
        }
    }
}
