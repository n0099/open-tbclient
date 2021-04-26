package d.a.i0.w.w;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.r.q.a2;
import d.a.i0.r.s.a;
import d.a.i0.s.c.h0;
import d.a.i0.s.c.v;
import d.a.j0.d3.y;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class e extends d.a.i0.w.e implements y.d {
    public NewWriteModel.g A;
    public d.a.i0.w.w.c B;
    public d.a.i0.w.w.b C;
    public boolean D;
    public TextWatcher E;
    public d.a.i0.w.w.f F;
    public int G;
    public EditorTools H;
    public boolean I;
    public LocationModel.e J;
    public LocationModel.f K;
    public final NewWriteModel.g L;
    public final d.a.c.a.e M;

    /* renamed from: f  reason: collision with root package name */
    public WriteImagesInfo f50004f;

    /* renamed from: g  reason: collision with root package name */
    public String f50005g;

    /* renamed from: h  reason: collision with root package name */
    public SpanGroupManager f50006h;

    /* renamed from: i  reason: collision with root package name */
    public VoiceData$VoiceModel f50007i;
    public String j;
    public LocationModel k;
    public NewWriteModel l;
    public ImageModel m;
    public DataModel<?> n;
    public ForumData o;
    public a2 p;
    public String q;
    public TbPageContext r;
    public String s;
    public String t;
    public String u;
    public long v;
    public String w;
    public int x;
    public VideoInfo y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements LocationModel.e {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            e.this.r.showToast(R.string.no_network_guide);
            e.this.b0(0, false, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                e.this.b0(2, true, locationData.getFormatted_address());
            } else {
                onFail(null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            if (e.this.I) {
                TbPageContext tbPageContext = e.this.r;
                if (StringUtils.isNull(str)) {
                    str = e.this.a().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
            }
            e.this.b0(0, false, null);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements LocationModel.f {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void a() {
            e.this.b0(0, false, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void b(String str) {
            e.this.b0(2, true, str);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            e.this.b0(0, true, null);
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (d.a.c.e.p.j.z()) {
                e.this.b0(1, true, null);
                e.this.k.F();
            } else {
                e.this.J.a();
            }
            aVar.dismiss();
        }
    }

    /* renamed from: d.a.i0.w.w.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1085e implements NewWriteModel.g {
        public C1085e() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            if (writeData == null) {
                writeData = e.this.l.T();
            }
            if (z) {
                e.this.Y(true);
                WriteData T = e.this.l.T();
                e.this.S();
                y.p(e.this.q, null);
                if (T == null) {
                    return;
                }
                if (T.getType() == 2) {
                    y.i(T.getThreadId(), e.this);
                }
            } else if (writeData != null && h0Var != null && !TextUtils.isEmpty(h0Var.d())) {
                writeData.setVcodeMD5(h0Var.b());
                writeData.setVcodeUrl(h0Var.c());
                writeData.setVcodeExtra(h0Var.a());
                if (e.this.p != null) {
                    writeData.setBaijiahaoData(e.this.p.V());
                }
                if (d.a.i0.a1.a.b(h0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(e.this.r.getPageActivity(), 12006, writeData, false, h0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(e.this.r.getPageActivity(), writeData, 12006)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(e.this.r.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            }
            e eVar = e.this;
            eVar.G(eVar.l.T());
            NewWriteModel.g gVar = e.this.A;
            if (gVar != null) {
                gVar.callback(z, postWriteCallBackData, h0Var, writeData, antiData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<Void, Integer, Void> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.j));
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends d.a.c.a.e {
        public g() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj instanceof Bitmap) {
                e.this.l.Z(true);
            }
        }
    }

    public e(EditorTools editorTools) {
        super(editorTools);
        this.f50004f = new WriteImagesInfo();
        this.f50005g = "";
        this.l = null;
        this.m = null;
        this.q = null;
        this.s = null;
        this.x = 0;
        this.D = false;
        this.G = 0;
        this.I = true;
        this.J = new a();
        this.K = new b();
        this.L = new C1085e();
        this.M = new g();
        this.H = editorTools;
    }

    public void A() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.r.getPageActivity())));
    }

    public boolean B() {
        LinkedList<ImageFileInfo> chosedFiles;
        WriteImagesInfo writeImagesInfo = this.f50004f;
        return (writeImagesInfo == null || (chosedFiles = writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean C() {
        if (StringUtils.isNull(this.f50005g)) {
            WriteImagesInfo writeImagesInfo = this.f50004f;
            if (writeImagesInfo == null || writeImagesInfo.size() <= 0) {
                VoiceData$VoiceModel voiceData$VoiceModel = this.f50007i;
                if (voiceData$VoiceModel == null || StringUtils.isNull(voiceData$VoiceModel.getId())) {
                    VideoInfo videoInfo = this.y;
                    return videoInfo != null && videoInfo.isAvaliable();
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public boolean D() {
        VoiceData$VoiceModel voiceData$VoiceModel = this.f50007i;
        return (voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || this.f50007i.duration <= 0) ? false : true;
    }

    public void E() {
        this.I = false;
    }

    public void F(TbPageContext tbPageContext, Bundle bundle) {
        NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
        this.l = newWriteModel;
        newWriteModel.d0(this.L);
        ImageModel imageModel = new ImageModel(tbPageContext);
        this.m = imageModel;
        imageModel.setLoadDataCallBack(this.M);
        LocationModel locationModel = new LocationModel(tbPageContext);
        this.k = locationModel;
        locationModel.I(this.J);
        this.k.J(this.K);
        if (bundle != null) {
            this.f50004f.parseJson(bundle.getString("write_images"));
            this.j = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        WriteImagesInfo writeImagesInfo = this.f50004f;
        if (writeImagesInfo != null) {
            writeImagesInfo.setMaxImagesAllowed(this.z ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
            a().A(new d.a.i0.w.a(2, 12, " "));
        }
        if (!this.k.v() && a() != null) {
            a().A(new d.a.i0.w.a(20, 8, null));
        }
        WriteImagesInfo writeImagesInfo2 = this.f50004f;
        if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.f50004f.getChosedFiles().size() <= 0) {
            return;
        }
        EditorTools a2 = a();
        a2.A(new d.a.i0.w.a(2, 10, this.f50004f.getChosedFiles().size() + ""));
    }

    public void G(WriteData writeData) {
        if (writeData == null) {
            return;
        }
        this.f50004f = new WriteImagesInfo();
        if (writeData.getWriteImagesInfo() != null) {
            this.f50004f.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.f50004f;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.f50004f.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.A(new d.a.i0.w.a(2, 10, this.f50004f.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.f50004f;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().A(new d.a.i0.w.a(2, 10, null));
        }
        String content = writeData.getContent();
        this.f50005g = content;
        a0(content);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void H(int i2, int i3, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        PostWriteCallBackData postWriteCallBackData = null;
        if (i3 != -1) {
            if (i2 == 12001) {
                n();
            } else if (i2 == 12002) {
                if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                    return;
                }
                this.f50004f.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
            } else if (i2 != 12006) {
            } else {
                if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                }
                PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                NewWriteModel.g gVar = this.A;
                if (gVar != null) {
                    gVar.callback(false, postWriteCallBackData2, null, this.l.T(), null);
                }
            }
        } else if (i2 == 11001) {
            L(null, null);
        } else if (i2 == 12006) {
            WriteData T = this.l.T();
            PostWriteCallBackData postWriteCallBackData3 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            if (T != null) {
                T.deleteUploadedTempImages();
            }
            this.l.f0(null);
            this.l.Z(false);
            this.f50007i = null;
            this.y = null;
            if (!TextUtils.isEmpty(this.q)) {
                y.p(this.q, null);
            }
            Y(true);
            NewWriteModel.g gVar2 = this.A;
            if (gVar2 != null) {
                gVar2.callback(true, postWriteCallBackData3, null, T, null);
            }
        } else if (i2 == 12012) {
            u(intent);
        } else if (i2 == 13010) {
            if (a() == null) {
                return;
            }
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.parseFromIntent(intent);
            if (videoInfo.isAvaliable()) {
                this.y = videoInfo;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.XIAOYING_DURATION);
                statisticItem.param("duration", this.y.getVideoDuration());
                TiebaStatic.log(statisticItem);
                c0();
                a().A(new d.a.i0.w.a(28, 20, this.y));
                a().A(new d.a.i0.w.a(28, -1, this.y));
            }
        } else if (i2 == 23004) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
        } else if (i2 == 25004) {
            if (intent != null) {
                W(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
            }
        } else if (i2 == 11025) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.r.getPageActivity(), 12004, true)));
        } else if (i2 == 11026) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.r.getPageActivity(), 12005, true)));
        } else if (i2 == 12009 || i2 == 12010) {
            if (i2 == 12010) {
                q(intent);
            }
        } else {
            switch (i2) {
                case 12002:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        q(intent);
                    } else {
                        p(intent);
                    }
                    a().invalidate();
                    return;
                case 12003:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("delete", false)) {
                        X();
                        this.l.Z(false);
                        return;
                    }
                    this.m.x(intent.getStringExtra("file_name"));
                    return;
                case 12004:
                    if (intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) == null) {
                        return;
                    }
                    V(stringArrayListExtra);
                    return;
                default:
                    return;
            }
        }
    }

    public void I() {
        this.l.cancelLoadData();
        this.m.cancelLoadData();
        this.k.cancelLoadData();
    }

    public void J() {
        if (!PermissionUtil.checkLocationForGoogle(this.r.getPageActivity())) {
            PermissionUtil.reuqestLocation(this.r.getPageActivity(), 0);
        } else {
            v0();
        }
    }

    public void K(Bundle bundle) {
        WriteImagesInfo writeImagesInfo = this.f50004f;
        if (writeImagesInfo != null) {
            bundle.putString("write_images", writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.j);
    }

    public void L(String str, WriteData writeData) {
        a2 a2Var;
        if (this.l.T() == null) {
            WriteData t = this.n.t(str);
            if (t != null && (a2Var = this.p) != null) {
                t.setBaijiahaoData(a2Var.V());
            }
            this.l.f0(t);
        }
        if (this.l.T() == null) {
            return;
        }
        this.l.setSpanGroupManager(this.f50006h);
        boolean z = true;
        if (this.D) {
            this.l.T().setCanNoForum(true);
            if (this.o != null) {
                this.l.T().setVForumId(this.o.getId());
                this.l.T().setVForumName(this.o.getName());
            }
        } else {
            this.l.T().setCanNoForum(false);
            this.l.T().setVForumId("");
            this.l.T().setVForumName("");
        }
        this.l.T().setIsBJHPost(this.z);
        this.l.T().setWriteImagesInfo(this.f50004f);
        this.l.T().setVideoInfo(this.y);
        this.l.Z(this.f50004f.size() > 0);
        WriteData T = this.l.T();
        LocationModel locationModel = this.k;
        T.setHasLocationData((locationModel == null || !locationModel.v()) ? false : false);
        if (str == null) {
            this.l.T().setContent(this.f50005g);
        }
        VoiceData$VoiceModel voiceData$VoiceModel = this.f50007i;
        if (voiceData$VoiceModel != null) {
            if (voiceData$VoiceModel.getId() != null) {
                this.l.T().setVoice(this.f50007i.getId());
                this.l.T().setVoiceDuringTime(this.f50007i.duration);
            } else {
                this.l.T().setVoice(null);
                this.l.T().setVoiceDuringTime(-1);
            }
        } else {
            this.l.T().setVoice(null);
            this.l.T().setVoiceDuringTime(-1);
        }
        if (!this.l.Q()) {
            this.r.showToast(R.string.write_img_limit);
            return;
        }
        d.a.i0.w.w.b bVar = this.C;
        if (bVar == null || !bVar.a()) {
            d.a.i0.w.w.c cVar = this.B;
            if (cVar != null) {
                cVar.a();
            }
            o(this.l.T());
            if (!this.l.i0()) {
            }
        }
    }

    public void M(AntiData antiData) {
        if (antiData != null) {
            this.s = antiData.getVoice_message();
        }
    }

    public void N(ForumData forumData, UserData userData) {
        this.o = forumData;
    }

    public void O(MetaData metaData, String str, String str2) {
        if (a() == null || metaData == null) {
            return;
        }
        this.v = metaData.getUserIdLong();
        this.t = metaData.getUserName();
        this.u = metaData.getName_show();
        this.q = str;
        this.w = str2;
    }

    public void P() {
        if (this.z || this.k == null || d.a.j0.d3.m0.b.a().d() || !UtilHelper.isSystemLocationProviderEnabled(this.r.getPageActivity()) || !TbadkCoreApplication.getInst().getLocationShared()) {
            return;
        }
        this.k.D();
    }

    public void Q() {
        if (this.k.v()) {
            if (this.k.z()) {
                this.J.b(d.a.j0.d3.m0.b.a().b());
                return;
            }
            if (l.D()) {
                this.k.D();
            }
            b0(0, true, null);
            return;
        }
        b0(0, false, null);
    }

    public void R() {
        EditorTools editorTools = this.H;
        if (editorTools != null) {
            editorTools.y();
        }
    }

    public void S() {
        this.l.f0(null);
        this.l.Z(false);
        this.f50007i = null;
        this.y = null;
        this.f50004f.clear();
    }

    public void T() {
        TextWatcher textWatcher;
        d.a.i0.w.w.f fVar = this.F;
        if (fVar == null || (textWatcher = this.E) == null) {
            return;
        }
        fVar.j(textWatcher);
    }

    public void U(String str) {
        WriteData T = this.l.T();
        if (T == null) {
            T = new WriteData(1);
            T.setThreadId(str);
            T.setWriteImagesInfo(this.f50004f);
        }
        T.setContent(this.f50005g);
        T.setVideoInfo(this.y);
        T.setVoiceModel(this.f50007i);
        y.p(str, T);
    }

    public final void V(ArrayList<String> arrayList) {
        if (a() != null) {
            a().A(new d.a.i0.w.a(17, 27, arrayList));
        }
    }

    public void W(String str) {
        if (a() != null) {
            a().A(new d.a.i0.w.a(44, 27, str));
        }
    }

    public final void X() {
        if (a() != null) {
            a().A(new d.a.i0.w.a(13, -1, null));
        }
    }

    public final void Y(boolean z) {
        if (a() != null) {
            if (z) {
                a().A(new d.a.i0.w.a(2, 10, null));
                a().A(new d.a.i0.w.a(2, 6, null));
            }
            a().A(new d.a.i0.w.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void Z() {
        if (StringUtils.isNull(this.t)) {
            return;
        }
        long j = this.v;
        if (j <= 0) {
            return;
        }
        if (String.valueOf(j).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            l.L(this.r.getPageActivity(), R.string.can_not_send_gift_to_yourself);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.r.getPageActivity(), this.v, this.t, this.u, GiftTabActivityConfig.FROM_PB, d.a.c.e.m.b.f(this.q, 0L), d.a.c.e.m.b.f(this.w, 0L))));
    }

    public final void a0(String str) {
        if (a() != null) {
            a().A(new d.a.i0.w.a(6, 27, str));
        }
    }

    public final void b0(int i2, boolean z, String str) {
        this.x = i2;
        if (a() != null) {
            a().A(new d.a.i0.w.a(19, 27, new d.a.i0.w.u.a(i2, z, str)));
        }
    }

    public final void c0() {
        if (a() != null) {
            a().A(new d.a.i0.w.a(2, 19, " "));
        }
    }

    public void d0(d.a.i0.w.w.b bVar) {
        this.C = bVar;
    }

    public void e0(TbPageContext tbPageContext) {
        this.r = tbPageContext;
    }

    public void f0(boolean z) {
        BLauncher bLauncher;
        if (a() == null || (bLauncher = (BLauncher) a().m(5)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void g0(int i2) {
        this.G = i2;
    }

    public void h(v vVar) {
        if (vVar == null) {
            return;
        }
        if (vVar.e() == EmotionGroupType.BIG_EMOTION || vVar.e() == EmotionGroupType.USER_COLLECT) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(vVar.b());
            imageFileInfo.width = vVar.g();
            imageFileInfo.height = vVar.a();
            this.f50004f.addChooseFile(imageFileInfo);
            this.f50004f.updateQuality();
        }
    }

    public void h0(boolean z) {
        this.D = z;
    }

    public void i(TextWatcher textWatcher) {
        k();
        d.a.i0.w.w.f fVar = this.F;
        if (fVar == null || textWatcher == null) {
            return;
        }
        fVar.g(textWatcher);
    }

    public void i0(boolean z) {
        BLauncher bLauncher;
        if (a() == null || (bLauncher = (BLauncher) a().m(23)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void j(int i2) {
        if (this.F == null && a() != null) {
            this.F = (d.a.i0.w.w.f) a().n(27);
        }
        d.a.i0.w.w.f fVar = this.F;
        if (fVar != null) {
            fVar.h(i2);
        }
    }

    public void j0(DataModel<?> dataModel) {
        this.n = dataModel;
    }

    public final void k() {
        if (this.F != null || a() == null) {
            return;
        }
        this.F = (d.a.i0.w.w.f) a().n(27);
    }

    public void k0(String str) {
        if (this.F == null && a() != null) {
            this.F = (d.a.i0.w.w.f) a().n(27);
        }
        d.a.i0.w.w.f fVar = this.F;
        if (fVar != null) {
            fVar.l(str);
        }
    }

    public void l() {
        WriteImagesInfo writeImagesInfo = this.f50004f;
        if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
            this.f50004f.clear();
        }
        VideoInfo videoInfo = this.y;
        if (videoInfo != null && videoInfo.isAvaliable()) {
            this.y = null;
        }
        a().A(new d.a.i0.w.a(2, 19, null));
        t0(null);
        a().A(new d.a.i0.w.a(2, 6, null));
        a().A(new d.a.i0.w.a(33, 6, null));
        if (!StringUtils.isNull(this.f50005g)) {
            this.f50005g = "";
        }
        a0("");
        this.l.f0(null);
        this.l.Z(false);
    }

    public void l0(int i2) {
        if (this.F == null && a() != null) {
            this.F = (d.a.i0.w.w.f) a().n(27);
        }
        d.a.i0.w.w.f fVar = this.F;
        if (fVar != null) {
            fVar.m(i2);
        }
    }

    public void m() {
        this.y = null;
    }

    public void m0(String str) {
        this.f50005g = str;
    }

    public final void n() {
        new f().execute(new Void[0]);
    }

    public void n0(NewWriteModel.g gVar) {
        this.A = gVar;
    }

    public void o(WriteData writeData) {
        if (writeData == null) {
            return;
        }
        int i2 = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i3 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i3++;
            }
            if (i3 > 0 && this.G > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i3);
                statisticItem.param("obj_source", this.G);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem);
            }
        }
        if (writeData.getWriteImagesInfo() == null || ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            return;
        }
        for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
            if (imageFileInfo.getImageType() == 1) {
                i2++;
            }
        }
        if (i2 <= 0 || this.G <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i2);
        statisticItem2.param("obj_source", this.G);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public void o0(d.a.i0.w.w.c cVar) {
        this.B = cVar;
    }

    @Override // d.a.j0.d3.y.d
    public void onDraftLoaded(WriteData writeData) {
        if (writeData == null) {
            return;
        }
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            if (this.y == null) {
                this.y = new VideoInfo();
            }
            this.y.copy(writeData.getVideoInfo());
            c0();
            a().A(new d.a.i0.w.a(39, -1, this.y));
        }
        if (writeData.getWriteImagesInfo() != null && this.f50004f.size() == 0) {
            this.f50004f.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.f50004f;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.f50004f.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.A(new d.a.i0.w.a(2, 10, this.f50004f.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.f50004f;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().A(new d.a.i0.w.a(2, 10, null));
        }
        if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
            if (this.f50007i == null) {
                this.f50007i = new VoiceData$VoiceModel();
            }
            this.f50007i.copy(writeData.getVoiceModel());
        }
        if (!k.isEmpty(writeData.getContent()) && k.isEmpty(this.f50005g)) {
            String content = writeData.getContent();
            this.f50005g = content;
            a0(content);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public final void p(Intent intent) {
        w(intent, true);
    }

    public void p0(boolean z) {
        BLauncher bLauncher;
        if (a() == null || (bLauncher = (BLauncher) a().m(2)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public final void q(Intent intent) {
        this.j = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.j;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0) {
                Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.e(this.r.getPageActivity(), l.k(this.r.getPageActivity())), l.e(this.r.getPageActivity(), l.i(this.r.getPageActivity())));
                Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                if (loadResizedBitmap != rotateBitmapBydegree) {
                    loadResizedBitmap.recycle();
                }
                FileHelper.SaveFile(TbConfig.LOCAL_CAMERA_DIR, this.j, rotateBitmapBydegree, 100);
                rotateBitmapBydegree.recycle();
            }
        } catch (Exception unused) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        this.f50004f.addChooseFile(imageFileInfo);
        this.f50004f.updateQuality();
        z(false, null);
    }

    public void q0(SpanGroupManager spanGroupManager) {
        this.f50006h = spanGroupManager;
    }

    public TbPageContext r() {
        return this.r;
    }

    public void r0(a2 a2Var) {
        this.p = a2Var;
    }

    public void s(String str) {
        y.i(str, this);
    }

    public void s0(String str) {
        this.q = str;
    }

    public int t() {
        return this.x;
    }

    public void t0(VoiceData$VoiceModel voiceData$VoiceModel) {
        this.f50007i = voiceData$VoiceModel;
    }

    public final void u(Intent intent) {
        w(intent, false);
    }

    public final void u0() {
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.r.getPageActivity());
        aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new d()).setNegativeButton(R.string.cancel, new c()).create(this.r);
        aVar.show();
    }

    public d.a.i0.w.w.f v() {
        if (this.F == null && a() != null) {
            this.F = (d.a.i0.w.w.f) a().n(27);
        }
        return this.F;
    }

    public void v0() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.r.getPageActivity())) {
            this.r.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            u0();
        } else if (this.k.z()) {
            A();
        } else {
            this.k.H(false);
            b0(1, true, null);
            this.k.D();
        }
    }

    public final void w(Intent intent, boolean z) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.f50004f.parseJson(stringExtra);
        this.f50004f.updateQuality();
        if (this.f50004f.getChosedFiles() != null) {
            z(false, null);
        }
    }

    public VideoInfo x() {
        return this.y;
    }

    public WriteImagesInfo y() {
        return this.f50004f;
    }

    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(0);
        pbEditorData.setContent(this.f50005g);
        pbEditorData.setWriteImagesInfo(this.f50004f);
        pbEditorData.setVoiceModel(this.f50007i);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        ForumData forumData = this.o;
        if (forumData != null) {
            threadData.setForumId(forumData.getId());
            threadData.setForumName(this.o.getName());
            threadData.setFirstDir(this.o.getFirst_class());
            threadData.setSecondDir(this.o.getSecond_class());
        }
        threadData.setAuthorId(this.v);
        threadData.setAuthorName(this.t);
        threadData.setAuthorNameShow(this.u);
        threadData.setPostId(this.w);
        threadData.setThreadId(this.q);
        threadData.isBJH = this.z;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.s);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.r.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }
}
