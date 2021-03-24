package d.b.i0.m2;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.tieba.postsearch.PostSearchHttpResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f56912a;

    /* renamed from: b  reason: collision with root package name */
    public String f56913b;

    /* renamed from: c  reason: collision with root package name */
    public String f56914c;
    public ArrayList<String> j;
    public CustomMessageListener m;

    /* renamed from: d  reason: collision with root package name */
    public int f56915d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f56916e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f56917f = 1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56918g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56919h = false;
    public boolean i = false;
    public int k = 0;
    public final HttpMessageListener l = new a(CmdConfigHttp.CMD_POST_SEARCH);

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.p(intValue);
                boolean z = d.this.i(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.f56912a.refreshResultListByTab(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.f(intValue);
                    d.this.r();
                    d.this.s();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.f56912a.getResources().getString(R.string.neterror);
                }
                d.this.f56912a.showToast(errorString);
                d.this.f56912a.refreshResultListByTab(intValue, null, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage == null || (data = customResponsedMessage.getData()) == null || !(data instanceof ArrayList)) {
                return;
            }
            d dVar = d.this;
            dVar.j = (ArrayList) data;
            dVar.f56912a.refreshHistoryList();
        }
    }

    public d(PostSearchActivity postSearchActivity) {
        b bVar = new b(2009001);
        this.m = bVar;
        this.f56912a = postSearchActivity;
        postSearchActivity.registerListener(bVar);
        this.f56912a.registerListener(this.l);
    }

    public final void f(int i) {
        if (i == 1) {
            this.f56915d++;
        } else if (i == 2) {
            this.f56916e++;
        } else if (i != 3) {
        } else {
            this.f56917f++;
        }
    }

    public void g() {
        ArrayList<String> arrayList = this.j;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f56912a.sendMessage(new CustomMessage(2009004));
    }

    public final HttpMessage h(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.f56913b);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, this.f56912a.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.k));
        if (i == 1) {
            httpMessage.addParam("sm", 1);
            httpMessage.addParam("only_thread", 0);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f56915d);
        } else if (i == 2) {
            httpMessage.addParam("sm", 2);
            httpMessage.addParam("only_thread", 0);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f56916e);
        } else if (i == 3) {
            httpMessage.addParam("sm", 2);
            httpMessage.addParam("only_thread", 1);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f56917f);
        }
        return httpMessage;
    }

    public final int i(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return 0;
                }
                return this.f56917f;
            }
            return this.f56916e;
        }
        return this.f56915d;
    }

    public void j() {
        this.f56912a.sendMessage(new CustomMessage(2009001));
    }

    public final void k(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    public boolean l(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.f56913b)) {
            q();
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                return m(str);
            }
            return n(str);
        }
        return o(str);
    }

    public boolean m(String str) {
        if (this.i) {
            return false;
        }
        this.f56913b = str;
        this.k = 3;
        this.f56912a.sendMessage(h(3));
        this.i = true;
        return true;
    }

    public boolean n(String str) {
        if (this.f56919h) {
            return false;
        }
        this.f56913b = str;
        this.k = 2;
        this.f56912a.sendMessage(h(2));
        this.f56919h = true;
        return true;
    }

    public boolean o(String str) {
        if (this.f56918g) {
            return false;
        }
        this.f56913b = str;
        this.k = 1;
        this.f56912a.sendMessage(h(1));
        this.f56918g = true;
        return true;
    }

    public final void p(int i) {
        if (i == 1) {
            this.f56918g = false;
        } else if (i == 2) {
            this.f56919h = false;
        } else if (i != 3) {
        } else {
            this.i = false;
        }
    }

    public void q() {
        this.f56915d = 1;
        this.f56916e = 1;
        this.f56917f = 1;
    }

    public void r() {
        if (StringUtils.isNull(this.f56913b) || this.f56913b.equals(this.f56914c)) {
            return;
        }
        this.f56912a.sendMessage(new CustomMessage(2009003, this.f56913b));
        this.f56914c = this.f56913b;
    }

    public final void s() {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.remove(this.f56913b);
        this.j.add(0, this.f56913b);
        k(this.j);
    }
}
