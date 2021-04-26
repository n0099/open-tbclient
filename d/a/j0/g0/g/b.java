package d.a.j0.g0.g;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.google.gson.Gson;
import d.a.c.c.f.k;
import d.a.j0.g0.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b extends k {

    /* renamed from: a  reason: collision with root package name */
    public c f54392a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f54393b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f54394c;

    /* renamed from: d  reason: collision with root package name */
    public Gson f54395d;

    public b(int i2) {
        super(i2);
        this.f54395d = new Gson();
        a();
    }

    public final void a() {
        int d2;
        this.f54393b = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (ListUtils.isEmpty(findHttpTasks)) {
            return;
        }
        for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
            String url = findHttpTasks.get(i2).getUrl();
            if (!d.a.c.e.p.k.isEmpty(url) && url.contains("?")) {
                String[] split = url.split("[?]");
                String str = split[1];
                String str2 = split[0];
                if (!d.a.c.e.p.k.isEmpty(str) && str.contains("=") && (d2 = d.a.c.e.m.b.d(str.split("[=]")[1], 0)) != 0) {
                    this.f54393b.put(d2, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                }
            }
        }
    }

    public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        HashMap<String, String> hashMap;
        String str = this.f54393b.get(socketMessage.getCmd());
        if (str != null && (hashMap = this.f54394c) != null && hashMap.get(str) != null && this.f54392a != null) {
            this.f54392a.a(str, this.f54395d.toJson(this.f54394c.get(str)), this.f54395d.toJson(this.f54395d.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    public void c(c cVar) {
        this.f54392a = cVar;
    }

    public void d(HashMap<String, String> hashMap) {
        this.f54394c = hashMap;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // d.a.c.c.f.f
    public /* bridge */ /* synthetic */ SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        SocketMessage socketMessage2 = socketMessage;
        b(socketMessage2, socketMessageTask);
        return socketMessage2;
    }
}
