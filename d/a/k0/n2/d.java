package d.a.k0.n2;

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
    public PostSearchActivity f57698a;

    /* renamed from: b  reason: collision with root package name */
    public String f57699b;

    /* renamed from: c  reason: collision with root package name */
    public String f57700c;
    public ArrayList<String> j;
    public CustomMessageListener m;

    /* renamed from: d  reason: collision with root package name */
    public int f57701d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f57702e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f57703f = 1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57704g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57705h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57706i = false;
    public int k = 0;
    public final HttpMessageListener l = new a(CmdConfigHttp.CMD_POST_SEARCH);

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
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
                    d.this.f57698a.refreshResultListByTab(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.f(intValue);
                    d.this.r();
                    d.this.s();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.f57698a.getResources().getString(R.string.neterror);
                }
                d.this.f57698a.showToast(errorString);
                d.this.f57698a.refreshResultListByTab(intValue, null, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
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
            dVar.f57698a.refreshHistoryList();
        }
    }

    public d(PostSearchActivity postSearchActivity) {
        b bVar = new b(2009001);
        this.m = bVar;
        this.f57698a = postSearchActivity;
        postSearchActivity.registerListener(bVar);
        this.f57698a.registerListener(this.l);
    }

    public final void f(int i2) {
        if (i2 == 1) {
            this.f57701d++;
        } else if (i2 == 2) {
            this.f57702e++;
        } else if (i2 != 3) {
        } else {
            this.f57703f++;
        }
    }

    public void g() {
        ArrayList<String> arrayList = this.j;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f57698a.sendMessage(new CustomMessage(2009004));
    }

    public final HttpMessage h(int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.f57699b);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, this.f57698a.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.k));
        if (i2 == 1) {
            httpMessage.addParam("sm", 1);
            httpMessage.addParam("only_thread", 0);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f57701d);
        } else if (i2 == 2) {
            httpMessage.addParam("sm", 2);
            httpMessage.addParam("only_thread", 0);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f57702e);
        } else if (i2 == 3) {
            httpMessage.addParam("sm", 2);
            httpMessage.addParam("only_thread", 1);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f57703f);
        }
        return httpMessage;
    }

    public final int i(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return 0;
                }
                return this.f57703f;
            }
            return this.f57702e;
        }
        return this.f57701d;
    }

    public void j() {
        this.f57698a.sendMessage(new CustomMessage(2009001));
    }

    public final void k(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.remove((size2 - i2) - 1);
            }
        }
    }

    public boolean l(String str, int i2) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.f57699b)) {
            q();
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return false;
                }
                return m(str);
            }
            return n(str);
        }
        return o(str);
    }

    public boolean m(String str) {
        if (this.f57706i) {
            return false;
        }
        this.f57699b = str;
        this.k = 3;
        this.f57698a.sendMessage(h(3));
        this.f57706i = true;
        return true;
    }

    public boolean n(String str) {
        if (this.f57705h) {
            return false;
        }
        this.f57699b = str;
        this.k = 2;
        this.f57698a.sendMessage(h(2));
        this.f57705h = true;
        return true;
    }

    public boolean o(String str) {
        if (this.f57704g) {
            return false;
        }
        this.f57699b = str;
        this.k = 1;
        this.f57698a.sendMessage(h(1));
        this.f57704g = true;
        return true;
    }

    public final void p(int i2) {
        if (i2 == 1) {
            this.f57704g = false;
        } else if (i2 == 2) {
            this.f57705h = false;
        } else if (i2 != 3) {
        } else {
            this.f57706i = false;
        }
    }

    public void q() {
        this.f57701d = 1;
        this.f57702e = 1;
        this.f57703f = 1;
    }

    public void r() {
        if (StringUtils.isNull(this.f57699b) || this.f57699b.equals(this.f57700c)) {
            return;
        }
        this.f57698a.sendMessage(new CustomMessage(2009003, this.f57699b));
        this.f57700c = this.f57699b;
    }

    public final void s() {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.remove(this.f57699b);
        this.j.add(0, this.f57699b);
        k(this.j);
    }
}
