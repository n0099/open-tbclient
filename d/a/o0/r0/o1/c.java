package d.a.o0.r0.o1;

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
import d.a.n0.s.c.i0;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final ForumWriteData f62996a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f62997b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f62998c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f62999d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f63000e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f63001f;

    /* renamed from: h  reason: collision with root package name */
    public b f63003h;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r.f0.a f63002g = null;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f63004i = new a();

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.g {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            c.this.c();
            if (postWriteCallBackData == null) {
                return;
            }
            if (!z) {
                c.this.f62999d.showToast(postWriteCallBackData.getErrorString());
                return;
            }
            TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", c.this.f62996a.forumId).param("fname", c.this.f62996a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            c.this.f62999d.setResult(-1, intent);
            c.this.f62999d.finish();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f62998c = null;
        this.f62999d = baseFragmentActivity;
        this.f62996a = forumWriteData;
        this.f62997b = serializableItemInfo;
        this.f62998c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        this.f63002g.h(false);
    }

    public final void d() {
        this.f63000e = new NewWriteModel();
        this.f63001f = new WriteData();
        this.f63000e.h0(this.f63004i);
    }

    public final void e() {
        this.f63002g = new d.a.n0.r.f0.a(this.f62999d);
    }

    public final void f() {
        this.f63000e.j0(this.f63001f);
        this.f63000e.m0();
        i();
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.z()) {
            l.L(this.f62999d, R.string.neterror);
        }
        SerializableItemInfo serializableItemInfo = this.f62997b;
        if (serializableItemInfo != null) {
            this.f63001f.setItem_id(String.valueOf(serializableItemInfo.id));
        }
        this.f63001f.setForumName(forumWriteData.forumName);
        this.f63001f.setContent(str);
        this.f63001f.setComment_head(str2);
        this.f63001f.setForumId(forumWriteData.forumId);
        this.f63001f.setTitle("");
        this.f63001f.setIsNoTitle(true);
        b bVar = this.f63003h;
        if (bVar != null) {
            bVar.a(this.f62998c);
        }
        f();
    }

    public void h(b bVar) {
        this.f63003h = bVar;
    }

    public void i() {
        this.f63002g.e(null);
        this.f63002g.i(R.string.sending);
        this.f63002g.h(true);
    }
}
