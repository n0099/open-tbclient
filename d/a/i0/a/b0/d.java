package d.a.i0.a.b0;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskHTTPResMsg;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.c.e.p.j;
import d.a.i0.a.h;
import d.a.i0.a.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements Handler.Callback {

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f47797f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.m.b<d.a.i0.a.b> f47798g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.a.b0.b f47799h;

    /* renamed from: e  reason: collision with root package name */
    public final Queue<c> f47796e = new LinkedList();

    /* renamed from: i  reason: collision with root package name */
    public boolean f47800i = false;
    public final Handler j = new Handler(this);
    public d.a.c.c.g.a k = new a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627);
    public CustomMessageListener l = new b(2921379);

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: d.a.i0.a.b0.d$f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.i0.a.b0.a data;
            d.this.f47800i = false;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                d.this.r(responsedMessage);
                return;
            }
            e eVar = null;
            eVar = null;
            if (responsedMessage instanceof CompleteTaskHTTPResMsg) {
                data = ((CompleteTaskHTTPResMsg) responsedMessage).getData();
            } else {
                data = responsedMessage instanceof CompleteTaskSocketResMsg ? ((CompleteTaskSocketResMsg) responsedMessage).getData() : null;
            }
            if (data == null) {
                return;
            }
            if (d.this.f47799h == null) {
                d.this.f47799h = new d.a.i0.a.b0.b();
            }
            d.this.f47799h.d(data);
            d.this.f47799h.e();
            Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
            if (obj instanceof f) {
                f fVar = (f) obj;
                d.a.i0.a.b bVar = fVar.f47808a;
                if (data != null && data.x == 1) {
                    bVar.z = true;
                }
                d.this.t(bVar);
                eVar = fVar;
            } else if (obj instanceof e) {
                e eVar2 = (e) obj;
                d.this.s(eVar2.f47806a);
                eVar = eVar2;
            } else if (obj instanceof g) {
                n.b().g();
            }
            if (eVar != null) {
                d.this.f47796e.remove(eVar);
            }
            d.this.u();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof C1013d)) {
                return;
            }
            C1013d c1013d = (C1013d) customResponsedMessage.getData();
            d.this.k(c1013d.f47803a);
            d.this.l(c1013d.f47804b);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c {
    }

    /* renamed from: d.a.i0.a.b0.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1013d {

        /* renamed from: a  reason: collision with root package name */
        public List<h> f47803a;

        /* renamed from: b  reason: collision with root package name */
        public List<d.a.i0.a.b> f47804b;

        /* renamed from: c  reason: collision with root package name */
        public List<d.a.i0.a.b> f47805c;

        public void a(d.a.i0.a.b bVar) {
            List<d.a.i0.a.b> list = this.f47804b;
            if (list != null) {
                list.add(bVar);
            }
        }

        public void b(h hVar) {
            List<h> list = this.f47803a;
            if (list != null) {
                list.add(hVar);
            }
        }

        public void c(d.a.i0.a.b bVar) {
            List<d.a.i0.a.b> list = this.f47805c;
            if (list != null) {
                list.add(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends c {

        /* renamed from: a  reason: collision with root package name */
        public String f47806a;

        /* renamed from: b  reason: collision with root package name */
        public String f47807b;

        public e(String str) {
            this.f47806a = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends c {

        /* renamed from: a  reason: collision with root package name */
        public d.a.i0.a.b f47808a;

        public f(d.a.i0.a.b bVar) {
            this.f47808a = bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends c {
    }

    public d(BdUniqueId bdUniqueId) {
        this.f47797f = bdUniqueId;
        p();
        q();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        x();
        return false;
    }

    public final void k(List<h> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        LinkedList<d.a.i0.a.b> linkedList = new LinkedList();
        for (h hVar : list) {
            if (hVar != null && hVar.c() != null) {
                d.a.i0.a.b c2 = hVar.c();
                if (c2.M()) {
                    c2.e0(c2.F());
                    o(c2);
                } else if (c2.d() != 0 && c2.q() != 0) {
                    linkedList.add(c2);
                }
            }
        }
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (d.a.i0.a.b bVar : linkedList) {
            if (bVar != null) {
                HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(bVar.d()));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    hashMap.put(Integer.valueOf(bVar.d()), hashSet);
                }
                hashSet.add(Integer.valueOf(bVar.q()));
            }
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : hashMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            Iterator it = ((HashSet) entry.getValue()).iterator();
            while (it.hasNext()) {
                sb.append(it.next() + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            try {
                jSONObject.put(String.valueOf(entry.getKey()), sb);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        for (d.a.i0.a.b bVar2 : linkedList) {
            if (bVar2 != null) {
                d.a.i0.a.b0.c.a(jSONObject2, bVar2.d(), bVar2.q(), bVar2.E());
            }
        }
        e eVar = new e(jSONObject.toString());
        eVar.f47807b = jSONObject2.toString();
        this.f47796e.add(eVar);
        u();
    }

    public final void l(List<d.a.i0.a.b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (d.a.i0.a.b bVar : list) {
            if (bVar.M()) {
                bVar.e0(bVar.F());
                o(bVar);
            } else {
                this.f47796e.add(new f(bVar));
            }
        }
        u();
    }

    public void m() {
        d.a.i0.a.b0.b bVar = this.f47799h;
        if (bVar != null) {
            bVar.a();
        }
    }

    public BdUniqueId n() {
        return this.f47797f;
    }

    public final void o(d.a.i0.a.b bVar) {
        d.a.i0.m.b<d.a.i0.a.b> bVar2;
        if (bVar == null || (bVar2 = this.f47798g) == null) {
            return;
        }
        bVar2.a(bVar);
    }

    public final void p() {
        d.a.j0.d3.d0.a.h(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, d.a.j0.d3.d0.a.a(TbConfig.COMPLETE_TASK_URL, 309627));
        tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void q() {
        this.k.setTag(n());
        this.l.setTag(n());
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(this.l);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: d.a.i0.a.b0.d$f */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
            return;
        }
        e eVar = null;
        Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
        if (obj instanceof f) {
            f fVar = (f) obj;
            o(fVar.f47808a);
            eVar = fVar;
        } else if (obj instanceof e) {
            eVar = (e) obj;
        }
        if (eVar != null) {
            this.f47796e.remove(eVar);
        }
        u();
    }

    public final void s(String str) {
        String[] split;
        if (str == null) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject == null) {
            return;
        }
        LinkedList<d.a.i0.a.b> linkedList = new LinkedList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                String string = jSONObject.getString(next);
                if (string != null && (split = string.split(",")) != null) {
                    for (String str2 : split) {
                        d.a.i0.a.b bVar = new d.a.i0.a.b();
                        bVar.S(d.a.c.e.m.b.d(next, 0));
                        bVar.b0(d.a.c.e.m.b.d(str2, 0));
                        if (bVar.d() != 0 && bVar.q() != 0) {
                            linkedList.add(bVar);
                        }
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        for (d.a.i0.a.b bVar2 : linkedList) {
            o(bVar2);
        }
    }

    public final void t(d.a.i0.a.b bVar) {
        if (bVar == null) {
            return;
        }
        o(bVar);
    }

    public final void u() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.j.sendMessage(obtain);
    }

    public void v(String str, int i2, String str2, Object obj) {
        if (j.z()) {
            this.f47800i = true;
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(i2);
            completeTaskReqMsg.setTag(this.f47797f);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.setToken(str2);
            completeTaskReqMsg.extra = obj;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    public void w(d.a.i0.m.b<d.a.i0.a.b> bVar) {
        this.f47798g = bVar;
    }

    public final boolean x() {
        c peek;
        e eVar;
        String str;
        d.a.i0.a.b bVar;
        try {
            if (this.f47800i || (peek = this.f47796e.peek()) == null) {
                return false;
            }
            if (peek instanceof f) {
                f fVar = (f) peek;
                if (fVar == null || (bVar = fVar.f47808a) == null) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(String.valueOf(bVar.d()), String.valueOf(bVar.q()));
                v(jSONObject.toString(), 1, bVar.E(), fVar);
                return true;
            } else if (!(peek instanceof e) || (eVar = (e) peek) == null || (str = eVar.f47806a) == null) {
                return false;
            } else {
                v(str, 1, eVar.f47807b, eVar);
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
