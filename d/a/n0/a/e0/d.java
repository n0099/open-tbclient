package d.a.n0.a.e0;

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
import d.a.n0.a.j;
import d.a.n0.a.p;
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
    public BdUniqueId f52476f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.m.b<d.a.n0.a.c> f52477g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.a.e0.b f52478h;

    /* renamed from: e  reason: collision with root package name */
    public final Queue<c> f52475e = new LinkedList();

    /* renamed from: i  reason: collision with root package name */
    public boolean f52479i = false;
    public final Handler j = new Handler(this);
    public d.a.c.c.g.a k = new a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627);
    public CustomMessageListener l = new b(2921379);

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: d.a.n0.a.e0.d$f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.n0.a.e0.a data;
            d.this.f52479i = false;
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
            if (d.this.f52478h == null) {
                d.this.f52478h = new d.a.n0.a.e0.b();
            }
            d.this.f52478h.d(data);
            d.this.f52478h.e();
            Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
            if (obj instanceof f) {
                f fVar = (f) obj;
                d.a.n0.a.c cVar = fVar.f52487a;
                if (data != null && data.x == 1) {
                    cVar.z = true;
                }
                d.this.t(cVar);
                eVar = fVar;
            } else if (obj instanceof e) {
                e eVar2 = (e) obj;
                d.this.s(eVar2.f52485a);
                eVar = eVar2;
            } else if (obj instanceof g) {
                p.b().g();
            }
            if (eVar != null) {
                d.this.f52475e.remove(eVar);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof C1157d)) {
                return;
            }
            C1157d c1157d = (C1157d) customResponsedMessage.getData();
            d.this.k(c1157d.f52482a);
            d.this.l(c1157d.f52483b);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c {
    }

    /* renamed from: d.a.n0.a.e0.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1157d {

        /* renamed from: a  reason: collision with root package name */
        public List<j> f52482a;

        /* renamed from: b  reason: collision with root package name */
        public List<d.a.n0.a.c> f52483b;

        /* renamed from: c  reason: collision with root package name */
        public List<d.a.n0.a.c> f52484c;

        public void a(d.a.n0.a.c cVar) {
            List<d.a.n0.a.c> list = this.f52483b;
            if (list != null) {
                list.add(cVar);
            }
        }

        public void b(j jVar) {
            List<j> list = this.f52482a;
            if (list != null) {
                list.add(jVar);
            }
        }

        public void c(d.a.n0.a.c cVar) {
            List<d.a.n0.a.c> list = this.f52484c;
            if (list != null) {
                list.add(cVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends c {

        /* renamed from: a  reason: collision with root package name */
        public String f52485a;

        /* renamed from: b  reason: collision with root package name */
        public String f52486b;

        public e(String str) {
            this.f52485a = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends c {

        /* renamed from: a  reason: collision with root package name */
        public d.a.n0.a.c f52487a;

        public f(d.a.n0.a.c cVar) {
            this.f52487a = cVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends c {
    }

    public d(BdUniqueId bdUniqueId) {
        this.f52476f = bdUniqueId;
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

    public final void k(List<j> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        LinkedList<d.a.n0.a.c> linkedList = new LinkedList();
        for (j jVar : list) {
            if (jVar != null && jVar.c() != null) {
                d.a.n0.a.c c2 = jVar.c();
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
        for (d.a.n0.a.c cVar : linkedList) {
            if (cVar != null) {
                HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(cVar.d()));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    hashMap.put(Integer.valueOf(cVar.d()), hashSet);
                }
                hashSet.add(Integer.valueOf(cVar.q()));
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
        for (d.a.n0.a.c cVar2 : linkedList) {
            if (cVar2 != null) {
                d.a.n0.a.e0.c.a(jSONObject2, cVar2.d(), cVar2.q(), cVar2.E());
            }
        }
        e eVar = new e(jSONObject.toString());
        eVar.f52486b = jSONObject2.toString();
        this.f52475e.add(eVar);
        u();
    }

    public final void l(List<d.a.n0.a.c> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (d.a.n0.a.c cVar : list) {
            if (cVar.M()) {
                cVar.e0(cVar.F());
                o(cVar);
            } else {
                this.f52475e.add(new f(cVar));
            }
        }
        u();
    }

    public void m() {
        d.a.n0.a.e0.b bVar = this.f52478h;
        if (bVar != null) {
            bVar.a();
        }
    }

    public BdUniqueId n() {
        return this.f52476f;
    }

    public final void o(d.a.n0.a.c cVar) {
        d.a.n0.m.b<d.a.n0.a.c> bVar;
        if (cVar == null || (bVar = this.f52477g) == null) {
            return;
        }
        bVar.a(cVar);
    }

    public final void p() {
        d.a.o0.e3.d0.a.h(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, d.a.o0.e3.d0.a.a(TbConfig.COMPLETE_TASK_URL, 309627));
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

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: d.a.n0.a.e0.d$f */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
            return;
        }
        e eVar = null;
        Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
        if (obj instanceof f) {
            f fVar = (f) obj;
            o(fVar.f52487a);
            eVar = fVar;
        } else if (obj instanceof e) {
            eVar = (e) obj;
        }
        if (eVar != null) {
            this.f52475e.remove(eVar);
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
        LinkedList<d.a.n0.a.c> linkedList = new LinkedList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                String string = jSONObject.getString(next);
                if (string != null && (split = string.split(",")) != null) {
                    for (String str2 : split) {
                        d.a.n0.a.c cVar = new d.a.n0.a.c();
                        cVar.S(d.a.c.e.m.b.d(next, 0));
                        cVar.b0(d.a.c.e.m.b.d(str2, 0));
                        if (cVar.d() != 0 && cVar.q() != 0) {
                            linkedList.add(cVar);
                        }
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        for (d.a.n0.a.c cVar2 : linkedList) {
            o(cVar2);
        }
    }

    public final void t(d.a.n0.a.c cVar) {
        if (cVar == null) {
            return;
        }
        o(cVar);
    }

    public final void u() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.j.sendMessage(obtain);
    }

    public void v(String str, int i2, String str2, Object obj) {
        if (d.a.c.e.p.j.z()) {
            this.f52479i = true;
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(i2);
            completeTaskReqMsg.setTag(this.f52476f);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.setToken(str2);
            completeTaskReqMsg.extra = obj;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    public void w(d.a.n0.m.b<d.a.n0.a.c> bVar) {
        this.f52477g = bVar;
    }

    public final boolean x() {
        c peek;
        e eVar;
        String str;
        d.a.n0.a.c cVar;
        try {
            if (this.f52479i || (peek = this.f52475e.peek()) == null) {
                return false;
            }
            if (peek instanceof f) {
                f fVar = (f) peek;
                if (fVar == null || (cVar = fVar.f52487a) == null) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(String.valueOf(cVar.d()), String.valueOf(cVar.q()));
                v(jSONObject.toString(), 1, cVar.E(), fVar);
                return true;
            } else if (!(peek instanceof e) || (eVar = (e) peek) == null || (str = eVar.f52485a) == null) {
                return false;
            } else {
                v(str, 1, eVar.f52486b, eVar);
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
