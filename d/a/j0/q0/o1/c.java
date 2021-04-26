package d.a.j0.q0.o1;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.i0.s.c.h0;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final ForumWriteData f58297a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f58298b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f58299c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f58300d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f58301e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f58302f;

    /* renamed from: h  reason: collision with root package name */
    public b f58304h;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.r.f0.a f58303g = null;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f58305i = new a();

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
                c.this.f58300d.showToast(postWriteCallBackData.getErrorString());
                return;
            }
            TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", c.this.f58297a.forumId).param("fname", c.this.f58297a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            c.this.f58300d.setResult(-1, intent);
            c.this.f58300d.finish();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f58299c = null;
        this.f58300d = baseFragmentActivity;
        this.f58297a = forumWriteData;
        this.f58298b = serializableItemInfo;
        this.f58299c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        this.f58303g.h(false);
    }

    public final void d() {
        this.f58301e = new NewWriteModel();
        this.f58302f = new WriteData();
        this.f58301e.d0(this.f58305i);
    }

    public final void e() {
        this.f58303g = new d.a.i0.r.f0.a(this.f58300d);
    }

    public final void f() {
        this.f58301e.f0(this.f58302f);
        this.f58301e.i0();
        i();
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.z()) {
            l.L(this.f58300d, R.string.neterror);
        }
        SerializableItemInfo serializableItemInfo = this.f58298b;
        if (serializableItemInfo != null) {
            this.f58302f.setItem_id(String.valueOf(serializableItemInfo.id));
        }
        this.f58302f.setForumName(forumWriteData.forumName);
        this.f58302f.setContent(str);
        this.f58302f.setComment_head(str2);
        this.f58302f.setForumId(forumWriteData.forumId);
        this.f58302f.setTitle("");
        this.f58302f.setIsNoTitle(true);
        b bVar = this.f58304h;
        if (bVar != null) {
            bVar.a(this.f58299c);
        }
        f();
    }

    public void h(b bVar) {
        this.f58304h = bVar;
    }

    public void i() {
        this.f58303g.e(null);
        this.f58303g.i(R.string.sending);
        this.f58303g.h(true);
    }
}
