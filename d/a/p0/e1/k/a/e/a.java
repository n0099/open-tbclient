package d.a.p0.e1.k.a.e;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.s.a;
import d.a.o0.s.c.i0;
import d.a.p0.h3.y;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends d.a.o0.w.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f55796f;

    /* renamed from: g  reason: collision with root package name */
    public String f55797g;

    /* renamed from: h  reason: collision with root package name */
    public long f55798h;

    /* renamed from: i  reason: collision with root package name */
    public NewWriteModel f55799i;
    public d.a.o0.w.w.c j;
    public d.a.o0.w.w.b k;
    public NewWriteModel.g l;
    public String m;
    public d.a.p0.e1.k.a.e.c n;
    public WriteImagesInfo o;
    public ImageModel p;
    public String q;
    public NewWriteModel.g r;
    public AntiHelper.k s;
    public final d.a.c.a.e t;

    /* renamed from: d.a.p0.e1.k.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1353a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f55800a;

        public C1353a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55800a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (this.f55800a.l != null) {
                    this.f55800a.l.callback(z, postWriteCallBackData, i0Var, writeData, antiData);
                }
                if (z) {
                    this.f55800a.f55797g = null;
                    this.f55800a.C(true);
                }
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (z) {
                    this.f55800a.f55799i.setWriteData(null);
                    this.f55800a.f55799i.d0(false);
                    this.f55800a.o.clear();
                    this.f55800a.j();
                    this.f55800a.a().A(new d.a.o0.w.a(2, 10, null));
                } else if (i2 != 230277 && i2 != 230278 && i2 != 340016 && i2 != 1990032 && !AntiHelper.m(i2, str)) {
                    if (i0Var != null && writeData != null && !StringUtils.isNull(i0Var.c())) {
                        writeData.setVcodeMD5(i0Var.b());
                        writeData.setVcodeUrl(i0Var.c());
                        writeData.setVcodeExtra(i0Var.a());
                        if (d.a.o0.a1.a.b(i0Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f55800a.m().getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, false, i0Var.d())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f55800a.m().getPageActivity(), writeData, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                        }
                    } else if (postWriteCallBackData != null && i2 == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f55800a.f55796f.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
                    } else if (i2 == 238010 || d.a.p0.r3.a.c(i2)) {
                    } else {
                        this.f55800a.m().showToast(str);
                    }
                } else {
                    this.f55800a.K(i2, str);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f55801a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55801a = aVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.f55801a.f55799i.d0(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements y.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55802e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55802e = aVar;
        }

        @Override // d.a.p0.h3.y.e
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            if (writeData.getWriteImagesInfo() != null && this.f55802e.o.size() == 0) {
                this.f55802e.o.copyFrom(writeData.getWriteImagesInfo());
                if (this.f55802e.o != null && this.f55802e.o.getChosedFiles() != null && this.f55802e.o.getChosedFiles().size() > 0) {
                    EditorTools a2 = this.f55802e.a();
                    a2.A(new d.a.o0.w.a(2, 10, this.f55802e.o.getChosedFiles().size() + ""));
                }
            }
            if (this.f55802e.o == null || this.f55802e.o.size() == 0) {
                this.f55802e.a().A(new d.a.o0.w.a(2, 10, null));
            }
            if (k.isEmpty(writeData.getContent()) || !k.isEmpty(this.f55802e.f55797g)) {
                return;
            }
            this.f55802e.f55797g = writeData.getContent();
            a aVar = this.f55802e;
            aVar.D(aVar.f55797g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55797g = "";
        this.m = null;
        this.o = new WriteImagesInfo();
        this.p = null;
        this.r = new C1353a(this);
        this.s = new b(this);
        this.t = new d(this);
    }

    public final void A(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(17, 29, arrayList));
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(13, -1, null));
    }

    public final void C(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(9, -1, Boolean.valueOf(z)));
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(6, 29, str));
    }

    public void E(d.a.o0.w.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void F(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.f55796f = tbPageContext;
        }
    }

    public void G(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) {
            this.l = gVar;
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f55797g = str;
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public void J(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.f55798h = j;
        }
    }

    public void K(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(this.f55796f.getPageActivity(), str, i2, this.s) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i2 != 230277 && i2 != 230278) {
                m().showToast(str);
            } else {
                L(str);
            }
        }
    }

    public final void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(m().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new c(this));
            aVar.create(m()).show();
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            I(true);
            a().j();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            y.u(String.valueOf(this.f55798h), null);
        }
    }

    public final void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            q(intent, true);
        }
    }

    public final void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
            this.q = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.q;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.e(this.f55796f.getPageActivity(), l.k(this.f55796f.getPageActivity())), l.e(this.f55796f.getPageActivity(), l.i(this.f55796f.getPageActivity())));
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
    }

    public TbPageContext<?> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f55796f : (TbPageContext) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            y.m(String.valueOf(this.f55798h), new e(this));
        }
    }

    public d.a.p0.e1.k.a.e.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.n == null && a() != null) {
                this.n = (d.a.p0.e1.k.a.e.c) a().n(29);
            }
            return this.n;
        }
        return (d.a.p0.e1.k.a.e.c) invokeV.objValue;
    }

    public final void p(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, intent) == null) {
            q(intent, false);
        }
    }

    public final void q(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.o.parseJson(stringExtra);
        this.o.updateQuality();
        if (this.o.getChosedFiles() != null) {
            t();
        }
    }

    public WriteImagesInfo r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.o : (WriteImagesInfo) invokeV.objValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f55798h : invokeV.longValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (!WriteActivityConfig.isAsyncWriting() || this.f55798h <= 0) {
                WriteActivityConfig.newInstance(this.f55796f.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.f55798h)).setFrom("topic_detail").setCallFrom("1").setContent(this.f55797g).setWriteImagesInfo(this.o).send();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            I(false);
            a().o();
        }
    }

    public void v(BaseActivity baseActivity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, baseActivity, bundle) == null) || baseActivity == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(baseActivity);
        this.f55799i = newWriteModel;
        newWriteModel.h0(this.r);
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
        a2.A(new d.a.o0.w.a(2, 10, this.o.getChosedFiles().size() + ""));
    }

    public void w(int i2, int i3, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<String> stringArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048602, this, i2, i3, intent) == null) {
            PostWriteCallBackData postWriteCallBackData2 = null;
            if (i3 != -1) {
                if (i3 == 0 && i2 == 12006) {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData2 = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData3 = postWriteCallBackData2;
                    NewWriteModel.g gVar = this.l;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData3, null, this.f55799i.X(), null);
                    }
                }
            } else if (i2 == 12006) {
                PostWriteCallBackData postWriteCallBackData4 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.l != null) {
                    this.f55797g = null;
                    C(true);
                    this.f55799i.setWriteData(null);
                    this.f55799i.d0(false);
                    this.o.clear();
                    j();
                    a().A(new d.a.o0.w.a(2, 10, null));
                    this.l.callback(true, postWriteCallBackData4, null, this.f55799i.X(), null);
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
                            this.f55799i.d0(false);
                            return;
                        }
                        this.p.B(intent.getStringExtra("file_name"));
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
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f55799i.cancelLoadData();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.f55799i.X() == null) {
                this.f55799i.setWriteData(new WriteData());
            }
            if (this.f55799i.X() == null) {
                return;
            }
            this.f55799i.X().setForumId("0");
            this.f55799i.X().setType(9);
            this.f55799i.X().setEntranceType(1);
            this.f55799i.X().setCanNoForum(true);
            this.f55799i.X().setTransmitForumData("[]");
            this.f55799i.X().setCallFrom("1");
            this.f55799i.X().setTopicId(String.valueOf(this.f55798h));
            this.f55799i.X().setContent(this.f55797g);
            this.f55799i.X().setIsNoTitle(true);
            this.f55799i.X().setTitle("");
            this.f55799i.X().setVoice(null);
            this.f55799i.X().setVoiceDuringTime(-1);
            if (!this.f55799i.U()) {
                m().showToast(R.string.write_img_limit);
                return;
            }
            d.a.o0.w.w.b bVar = this.k;
            if (bVar == null || !bVar.a()) {
                d.a.o0.w.w.c cVar = this.j;
                if (cVar != null) {
                    cVar.a();
                }
                if (!this.f55799i.l0()) {
                }
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            WriteData writeData = new WriteData(2);
            writeData.setContent(this.f55797g);
            writeData.setTopicId(String.valueOf(this.f55798h));
            writeData.setWriteImagesInfo(this.o);
            y.u(String.valueOf(this.f55798h), writeData);
        }
    }
}
