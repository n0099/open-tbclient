package d.b.i0.q0.o1;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.h0.s.c.h0;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final ForumWriteData f59793a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f59794b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f59795c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f59796d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f59797e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f59798f;

    /* renamed from: h  reason: collision with root package name */
    public b f59800h;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.a f59799g = null;
    public final NewWriteModel.g i = new a();

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.g {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            c.this.c();
            if (postWriteCallBackData == null) {
                return;
            }
            if (!z) {
                c.this.f59796d.showToast(postWriteCallBackData.getErrorString());
                return;
            }
            TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", c.this.f59793a.forumId).param("fname", c.this.f59793a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            c.this.f59796d.setResult(-1, intent);
            c.this.f59796d.finish();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f59795c = null;
        this.f59796d = baseFragmentActivity;
        this.f59793a = forumWriteData;
        this.f59794b = serializableItemInfo;
        this.f59795c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        this.f59799g.h(false);
    }

    public final void d() {
        this.f59797e = new NewWriteModel();
        this.f59798f = new WriteData();
        this.f59797e.d0(this.i);
    }

    public final void e() {
        this.f59799g = new d.b.h0.r.f0.a(this.f59796d);
    }

    public final void f() {
        this.f59797e.f0(this.f59798f);
        this.f59797e.i0();
        i();
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.z()) {
            l.K(this.f59796d, R.string.neterror);
        }
        SerializableItemInfo serializableItemInfo = this.f59794b;
        if (serializableItemInfo != null) {
            this.f59798f.setItem_id(String.valueOf(serializableItemInfo.id));
        }
        this.f59798f.setForumName(forumWriteData.forumName);
        this.f59798f.setContent(str);
        this.f59798f.setComment_head(str2);
        this.f59798f.setForumId(forumWriteData.forumId);
        this.f59798f.setTitle("");
        this.f59798f.setIsNoTitle(true);
        b bVar = this.f59800h;
        if (bVar != null) {
            bVar.a(this.f59795c);
        }
        f();
    }

    public void h(b bVar) {
        this.f59800h = bVar;
    }

    public void i() {
        this.f59799g.e(null);
        this.f59799g.i(R.string.sending);
        this.f59799g.h(true);
    }
}
