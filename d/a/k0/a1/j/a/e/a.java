package d.a.k0.a1.j.a.e;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.j0.r.s.a;
import d.a.j0.s.c.h0;
import d.a.k0.d3.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends d.a.j0.w.e {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f51804f;

    /* renamed from: g  reason: collision with root package name */
    public String f51805g;

    /* renamed from: h  reason: collision with root package name */
    public long f51806h;

    /* renamed from: i  reason: collision with root package name */
    public NewWriteModel f51807i;
    public d.a.j0.w.w.c j;
    public d.a.j0.w.w.b k;
    public NewWriteModel.g l;
    public String m;
    public d.a.k0.a1.j.a.e.c n;
    public WriteImagesInfo o;
    public ImageModel p;
    public String q;
    public NewWriteModel.g r;
    public AntiHelper.k s;
    public final d.a.c.a.e t;

    /* renamed from: d.a.k0.a1.j.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1196a implements NewWriteModel.g {
        public C1196a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            String str;
            if (a.this.l != null) {
                a.this.l.callback(z, postWriteCallBackData, h0Var, writeData, antiData);
            }
            if (z) {
                a.this.f51805g = null;
                a.this.C(true);
            }
            int i2 = -1;
            if (postWriteCallBackData != null) {
                i2 = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            } else {
                str = "";
            }
            if (z) {
                a.this.f51807i.f0(null);
                a.this.f51807i.Z(false);
                a.this.o.clear();
                a.this.j();
                a.this.a().A(new d.a.j0.w.a(2, 10, null));
            } else if (i2 != 230277 && i2 != 230278 && i2 != 340016 && i2 != 1990032 && !AntiHelper.m(i2, str)) {
                if (h0Var != null && writeData != null && !StringUtils.isNull(h0Var.c())) {
                    writeData.setVcodeMD5(h0Var.b());
                    writeData.setVcodeUrl(h0Var.c());
                    writeData.setVcodeExtra(h0Var.a());
                    if (d.a.j0.a1.a.b(h0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.m().getPageActivity(), 12006, writeData, false, h0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.m().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i2 == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.f51804f.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else if (i2 == 238010 || d.a.k0.n3.a.c(i2)) {
                } else {
                    a.this.m().showToast(str);
                }
            } else {
                a.this.K(i2, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AntiHelper.k {
        public b(a aVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.j0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.j0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c(a aVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.c.a.e {
        public d() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj instanceof Bitmap) {
                a.this.f51807i.Z(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements y.d {
        public e() {
        }

        @Override // d.a.k0.d3.y.d
        public void onDraftLoaded(WriteData writeData) {
            if (writeData == null) {
                return;
            }
            if (writeData.getWriteImagesInfo() != null && a.this.o.size() == 0) {
                a.this.o.copyFrom(writeData.getWriteImagesInfo());
                if (a.this.o != null && a.this.o.getChosedFiles() != null && a.this.o.getChosedFiles().size() > 0) {
                    EditorTools a2 = a.this.a();
                    a2.A(new d.a.j0.w.a(2, 10, a.this.o.getChosedFiles().size() + ""));
                }
            }
            if (a.this.o == null || a.this.o.size() == 0) {
                a.this.a().A(new d.a.j0.w.a(2, 10, null));
            }
            if (k.isEmpty(writeData.getContent()) || !k.isEmpty(a.this.f51805g)) {
                return;
            }
            a.this.f51805g = writeData.getContent();
            a aVar = a.this;
            aVar.D(aVar.f51805g);
        }
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.f51805g = "";
        this.m = null;
        this.o = new WriteImagesInfo();
        this.p = null;
        this.r = new C1196a();
        this.s = new b(this);
        this.t = new d();
    }

    public final void A(ArrayList<String> arrayList) {
        if (a() != null) {
            a().A(new d.a.j0.w.a(17, 29, arrayList));
        }
    }

    public final void B() {
        if (a() != null) {
            a().A(new d.a.j0.w.a(13, -1, null));
        }
    }

    public final void C(boolean z) {
        if (a() != null) {
            a().A(new d.a.j0.w.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public final void D(String str) {
        if (a() != null) {
            a().A(new d.a.j0.w.a(6, 29, str));
        }
    }

    public void E(d.a.j0.w.w.b bVar) {
        this.k = bVar;
    }

    public void F(TbPageContext<?> tbPageContext) {
        this.f51804f = tbPageContext;
    }

    public void G(NewWriteModel.g gVar) {
        this.l = gVar;
    }

    public void H(String str) {
        this.f51805g = str;
    }

    public void I(boolean z) {
    }

    public void J(long j) {
        this.f51806h = j;
    }

    public void K(int i2, String str) {
        if (AntiHelper.m(i2, str)) {
            if (AntiHelper.w(this.f51804f.getPageActivity(), str, i2, this.s) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        } else if (i2 != 230277 && i2 != 230278) {
            m().showToast(str);
        } else {
            L(str);
        }
    }

    public final void L(String str) {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(m().getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new c(this));
        aVar.create(m()).show();
    }

    public void M() {
        I(true);
        a().j();
    }

    public void j() {
        y.r(String.valueOf(this.f51806h), null);
    }

    public final void k(Intent intent) {
        q(intent, true);
    }

    public final void l(Intent intent) {
        this.q = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.q;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0) {
                Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.e(this.f51804f.getPageActivity(), l.k(this.f51804f.getPageActivity())), l.e(this.f51804f.getPageActivity(), l.i(this.f51804f.getPageActivity())));
                Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                if (loadResizedBitmap != rotateBitmapBydegree) {
                    loadResizedBitmap.recycle();
                }
                FileHelper.SaveFile(TbConfig.LOCAL_CAMERA_DIR, this.q, rotateBitmapBydegree, 100);
                rotateBitmapBydegree.recycle();
            }
        } catch (Exception unused) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        this.o.addChooseFile(imageFileInfo);
        this.o.updateQuality();
        if (this.o.getChosedFiles() != null) {
            t();
        }
    }

    public TbPageContext<?> m() {
        return this.f51804f;
    }

    public void n() {
        y.k(String.valueOf(this.f51806h), new e());
    }

    public d.a.k0.a1.j.a.e.c o() {
        if (this.n == null && a() != null) {
            this.n = (d.a.k0.a1.j.a.e.c) a().n(29);
        }
        return this.n;
    }

    public final void p(Intent intent) {
        q(intent, false);
    }

    public final void q(Intent intent, boolean z) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.o.parseJson(stringExtra);
        this.o.updateQuality();
        if (this.o.getChosedFiles() != null) {
            t();
        }
    }

    public WriteImagesInfo r() {
        return this.o;
    }

    public long s() {
        return this.f51806h;
    }

    public final void t() {
        if (!WriteActivityConfig.isAsyncWriting() || this.f51806h <= 0) {
            WriteActivityConfig.newInstance(this.f51804f.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.f51806h)).setFrom("topic_detail").setCallFrom("1").setContent(this.f51805g).setWriteImagesInfo(this.o).send();
        }
    }

    public void u() {
        I(false);
        a().o();
    }

    public void v(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(baseActivity);
        this.f51807i = newWriteModel;
        newWriteModel.d0(this.r);
        ImageModel imageModel = new ImageModel(baseActivity.getPageContext());
        this.p = imageModel;
        imageModel.setLoadDataCallBack(this.t);
        if (bundle != null) {
            this.o.parseJson(bundle.getString("write_images"));
            this.q = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        WriteImagesInfo writeImagesInfo = this.o;
        if (writeImagesInfo != null) {
            writeImagesInfo.setMaxImagesAllowed(9);
        }
        WriteImagesInfo writeImagesInfo2 = this.o;
        if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.o.getChosedFiles().size() <= 0) {
            return;
        }
        EditorTools a2 = a();
        a2.A(new d.a.j0.w.a(2, 10, this.o.getChosedFiles().size() + ""));
    }

    public void w(int i2, int i3, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<String> stringArrayListExtra;
        PostWriteCallBackData postWriteCallBackData2 = null;
        if (i3 != -1) {
            if (i3 == 0 && i2 == 12006) {
                if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                }
                PostWriteCallBackData postWriteCallBackData3 = postWriteCallBackData2;
                NewWriteModel.g gVar = this.l;
                if (gVar != null) {
                    gVar.callback(false, postWriteCallBackData3, null, this.f51807i.T(), null);
                }
            }
        } else if (i2 == 12006) {
            PostWriteCallBackData postWriteCallBackData4 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            if (this.l != null) {
                this.f51805g = null;
                C(true);
                this.f51807i.f0(null);
                this.f51807i.Z(false);
                this.o.clear();
                j();
                a().A(new d.a.j0.w.a(2, 10, null));
                this.l.callback(true, postWriteCallBackData4, null, this.f51807i.T(), null);
            }
        } else if (i2 == 12012) {
            p(intent);
        } else if (i2 == 13003) {
            if (intent != null) {
                try {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                } catch (Exception e2) {
                    BdLog.e(e2);
                    postWriteCallBackData = null;
                }
                this.r.callback(true, postWriteCallBackData, null, null, null);
            }
        } else if (i2 == 24007) {
            if (intent.getIntExtra("extra_share_status", 2) == 1) {
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                statisticItem.param("obj_locate", 6);
                if (shareItem != null) {
                    statisticItem.param("tid", shareItem.K);
                }
                statisticItem.param("pid", intent.getStringExtra("pid"));
                TiebaStatic.log(statisticItem);
            }
        } else if (i2 == 12009 || i2 == 12010) {
            if (i2 == 12010) {
                l(intent);
            }
        } else {
            switch (i2) {
                case 12002:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        l(intent);
                    } else {
                        k(intent);
                    }
                    a().invalidate();
                    return;
                case 12003:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("delete", false)) {
                        B();
                        this.f51807i.Z(false);
                        return;
                    }
                    this.p.x(intent.getStringExtra("file_name"));
                    return;
                case 12004:
                    if (intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) == null) {
                        return;
                    }
                    A(stringArrayListExtra);
                    return;
                default:
                    return;
            }
        }
    }

    public void x() {
        this.f51807i.cancelLoadData();
    }

    public void y() {
        if (this.f51807i.T() == null) {
            this.f51807i.f0(new WriteData());
        }
        if (this.f51807i.T() == null) {
            return;
        }
        this.f51807i.T().setForumId("0");
        this.f51807i.T().setType(9);
        this.f51807i.T().setEntranceType(1);
        this.f51807i.T().setCanNoForum(true);
        this.f51807i.T().setTransmitForumData("[]");
        this.f51807i.T().setCallFrom("1");
        this.f51807i.T().setTopicId(String.valueOf(this.f51806h));
        this.f51807i.T().setContent(this.f51805g);
        this.f51807i.T().setIsNoTitle(true);
        this.f51807i.T().setTitle("");
        this.f51807i.T().setVoice(null);
        this.f51807i.T().setVoiceDuringTime(-1);
        if (!this.f51807i.Q()) {
            m().showToast(R.string.write_img_limit);
            return;
        }
        d.a.j0.w.w.b bVar = this.k;
        if (bVar == null || !bVar.a()) {
            d.a.j0.w.w.c cVar = this.j;
            if (cVar != null) {
                cVar.a();
            }
            if (!this.f51807i.i0()) {
            }
        }
    }

    public void z() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.f51805g);
        writeData.setTopicId(String.valueOf(this.f51806h));
        writeData.setWriteImagesInfo(this.o);
        y.r(String.valueOf(this.f51806h), writeData);
    }
}
