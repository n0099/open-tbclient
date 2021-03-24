package d.b.i0.g0.g;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import d.b.b.c.f.d;
import d.b.i0.g0.c;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public c f54904a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f54905b;

    /* renamed from: c  reason: collision with root package name */
    public Gson f54906c;

    public a(int i) {
        super(i);
        this.f54906c = new Gson();
    }

    public String a(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        HashMap<String, String> hashMap = this.f54905b;
        if (hashMap != null) {
            return hashMap.get(replace);
        }
        return null;
    }

    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String a2 = a(httpMessageTask.getUrl());
        if (a2 != null && this.f54904a != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                json = netMessage.getSocketMessage() != null ? this.f54906c.toJson(netMessage.getSocketMessage().getData()) : "";
            } else {
                json = this.f54906c.toJson(httpMessage.getParams());
            }
            this.f54904a.a(httpMessageTask.getUrl(), this.f54906c.toJson(a2), this.f54906c.toJson(json));
        }
        return httpMessage;
    }

    public void c(c cVar) {
        this.f54904a = cVar;
    }

    public void d(HashMap<String, String> hashMap) {
        this.f54905b = hashMap;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // d.b.b.c.f.f
    public /* bridge */ /* synthetic */ HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        HttpMessage httpMessage2 = httpMessage;
        b(httpMessage2, httpMessageTask);
        return httpMessage2;
    }
}
