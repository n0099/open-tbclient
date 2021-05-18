package d.a.k0.g0.g;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import d.a.c.c.f.d;
import d.a.k0.g0.c;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public c f55096a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f55097b;

    /* renamed from: c  reason: collision with root package name */
    public Gson f55098c;

    public a(int i2) {
        super(i2);
        this.f55098c = new Gson();
    }

    public String a(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        HashMap<String, String> hashMap = this.f55097b;
        if (hashMap != null) {
            return hashMap.get(replace);
        }
        return null;
    }

    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String a2 = a(httpMessageTask.getUrl());
        if (a2 != null && this.f55096a != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                json = netMessage.getSocketMessage() != null ? this.f55098c.toJson(netMessage.getSocketMessage().getData()) : "";
            } else {
                json = this.f55098c.toJson(httpMessage.getParams());
            }
            this.f55096a.a(httpMessageTask.getUrl(), this.f55098c.toJson(a2), this.f55098c.toJson(json));
        }
        return httpMessage;
    }

    public void c(c cVar) {
        this.f55096a = cVar;
    }

    public void d(HashMap<String, String> hashMap) {
        this.f55097b = hashMap;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // d.a.c.c.f.f
    public /* bridge */ /* synthetic */ HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        HttpMessage httpMessage2 = httpMessage;
        b(httpMessage2, httpMessageTask);
        return httpMessage2;
    }
}
