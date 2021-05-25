package d.a.n0.r0.f2.a;

import com.squareup.wire.Message;
import d.a.m0.g0.b.h;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.ZoneRight.DataRes;
import tbclient.ZoneRight.Toast;
import tbclient.ZoneRight.ZoneRightResIdl;
/* loaded from: classes4.dex */
public class b implements h {

    /* renamed from: e  reason: collision with root package name */
    public boolean f58562e;

    /* renamed from: f  reason: collision with root package name */
    public int f58563f;

    /* renamed from: g  reason: collision with root package name */
    public String f58564g;

    /* renamed from: h  reason: collision with root package name */
    public int f58565h;

    /* renamed from: i  reason: collision with root package name */
    public String f58566i;

    @Override // d.a.m0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.a.m0.g0.b.h
    public void initByProtobuf(Message message) {
        if (message instanceof ZoneRightResIdl) {
            ZoneRightResIdl zoneRightResIdl = (ZoneRightResIdl) message;
            Error error = zoneRightResIdl.error;
            if (error != null) {
                this.f58563f = error.errorno.intValue();
                this.f58564g = zoneRightResIdl.error.usermsg;
            }
            DataRes dataRes = zoneRightResIdl.data;
            if (dataRes != null) {
                this.f58562e = dataRes.has_right.intValue() == 1;
                Toast toast = zoneRightResIdl.data.toast;
                if (toast != null) {
                    this.f58565h = toast.type.intValue();
                    this.f58566i = zoneRightResIdl.data.toast.content;
                }
            }
        }
    }
}
