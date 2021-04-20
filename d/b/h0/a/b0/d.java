package d.b.h0.a.b0;

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
import d.b.c.e.p.j;
import d.b.h0.a.h;
import d.b.h0.a.n;
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
    public BdUniqueId f49914f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.m.b<d.b.h0.a.b> f49915g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.a.b0.b f49916h;

    /* renamed from: e  reason: collision with root package name */
    public final Queue<c> f49913e = new LinkedList();
    public boolean i = false;
    public final Handler j = new Handler(this);
    public d.b.c.c.g.a k = new a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627);
    public CustomMessageListener l = new b(2921379);

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: d.b.h0.a.b0.d$f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.h0.a.b0.a data;
            d.this.i = false;
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
            if (d.this.f49916h == null) {
                d.this.f49916h = new d.b.h0.a.b0.b();
            }
            d.this.f49916h.d(data);
            d.this.f49916h.e();
            Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
            if (obj instanceof f) {
                f fVar = (f) obj;
                d.b.h0.a.b bVar = fVar.f49924a;
                if (data != null && data.x == 1) {
                    bVar.z = true;
                }
                d.this.t(bVar);
                eVar = fVar;
            } else if (obj instanceof e) {
                e eVar2 = (e) obj;
                d.this.s(eVar2.f49922a);
                eVar = eVar2;
            } else if (obj instanceof g) {
                n.b().g();
            }
            if (eVar != null) {
                d.this.f49913e.remove(eVar);
            }
            d.this.u();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof C1052d)) {
                return;
            }
            C1052d c1052d = (C1052d) customResponsedMessage.getData();
            d.this.k(c1052d.f49919a);
            d.this.l(c1052d.f49920b);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c {
    }

    /* renamed from: d.b.h0.a.b0.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1052d {

        /* renamed from: a  reason: collision with root package name */
        public List<h> f49919a;

        /* renamed from: b  reason: collision with root package name */
        public List<d.b.h0.a.b> f49920b;

        /* renamed from: c  reason: collision with root package name */
        public List<d.b.h0.a.b> f49921c;

        public void a(d.b.h0.a.b bVar) {
            List<d.b.h0.a.b> list = this.f49920b;
            if (list != null) {
                list.add(bVar);
            }
        }

        public void b(h hVar) {
            List<h> list = this.f49919a;
            if (list != null) {
                list.add(hVar);
            }
        }

        public void c(d.b.h0.a.b bVar) {
            List<d.b.h0.a.b> list = this.f49921c;
            if (list != null) {
                list.add(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends c {

        /* renamed from: a  reason: collision with root package name */
        public String f49922a;

        /* renamed from: b  reason: collision with root package name */
        public String f49923b;

        public e(String str) {
            this.f49922a = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends c {

        /* renamed from: a  reason: collision with root package name */
        public d.b.h0.a.b f49924a;

        public f(d.b.h0.a.b bVar) {
            this.f49924a = bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends c {
    }

    public d(BdUniqueId bdUniqueId) {
        this.f49914f = bdUniqueId;
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
        LinkedList<d.b.h0.a.b> linkedList = new LinkedList();
        for (h hVar : list) {
            if (hVar != null && hVar.c() != null) {
                d.b.h0.a.b c2 = hVar.c();
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
        for (d.b.h0.a.b bVar : linkedList) {
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
        for (d.b.h0.a.b bVar2 : linkedList) {
            if (bVar2 != null) {
                d.b.h0.a.b0.c.a(jSONObject2, bVar2.d(), bVar2.q(), bVar2.E());
            }
        }
        e eVar = new e(jSONObject.toString());
        eVar.f49923b = jSONObject2.toString();
        this.f49913e.add(eVar);
        u();
    }

    public final void l(List<d.b.h0.a.b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (d.b.h0.a.b bVar : list) {
            if (bVar.M()) {
                bVar.e0(bVar.F());
                o(bVar);
            } else {
                this.f49913e.add(new f(bVar));
            }
        }
        u();
    }

    public void m() {
        d.b.h0.a.b0.b bVar = this.f49916h;
        if (bVar != null) {
            bVar.a();
        }
    }

    public BdUniqueId n() {
        return this.f49914f;
    }

    public final void o(d.b.h0.a.b bVar) {
        d.b.h0.m.b<d.b.h0.a.b> bVar2;
        if (bVar == null || (bVar2 = this.f49915g) == null) {
            return;
        }
        bVar2.a(bVar);
    }

    public final void p() {
        d.b.i0.d3.d0.a.h(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, d.b.i0.d3.d0.a.a(TbConfig.COMPLETE_TASK_URL, 309627));
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

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: d.b.h0.a.b0.d$f */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
            return;
        }
        e eVar = null;
        Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
        if (obj instanceof f) {
            f fVar = (f) obj;
            o(fVar.f49924a);
            eVar = fVar;
        } else if (obj instanceof e) {
            eVar = (e) obj;
        }
        if (eVar != null) {
            this.f49913e.remove(eVar);
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
        LinkedList<d.b.h0.a.b> linkedList = new LinkedList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                String string = jSONObject.getString(next);
                if (string != null && (split = string.split(",")) != null) {
                    for (String str2 : split) {
                        d.b.h0.a.b bVar = new d.b.h0.a.b();
                        bVar.S(d.b.c.e.m.b.d(next, 0));
                        bVar.b0(d.b.c.e.m.b.d(str2, 0));
                        if (bVar.d() != 0 && bVar.q() != 0) {
                            linkedList.add(bVar);
                        }
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        for (d.b.h0.a.b bVar2 : linkedList) {
            o(bVar2);
        }
    }

    public final void t(d.b.h0.a.b bVar) {
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

    public void v(String str, int i, String str2, Object obj) {
        if (j.z()) {
            this.i = true;
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(i);
            completeTaskReqMsg.setTag(this.f49914f);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.setToken(str2);
            completeTaskReqMsg.extra = obj;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    public void w(d.b.h0.m.b<d.b.h0.a.b> bVar) {
        this.f49915g = bVar;
    }

    public final boolean x() {
        c peek;
        e eVar;
        String str;
        d.b.h0.a.b bVar;
        try {
            if (this.i || (peek = this.f49913e.peek()) == null) {
                return false;
            }
            if (peek instanceof f) {
                f fVar = (f) peek;
                if (fVar == null || (bVar = fVar.f49924a) == null) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(String.valueOf(bVar.d()), String.valueOf(bVar.q()));
                v(jSONObject.toString(), 1, bVar.E(), fVar);
                return true;
            } else if (!(peek instanceof e) || (eVar = (e) peek) == null || (str = eVar.f49922a) == null) {
                return false;
            } else {
                v(str, 1, eVar.f49923b, eVar);
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
