package com.repackage;

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
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.AtSelectData;
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
import com.repackage.cj8;
import com.repackage.nr4;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class l17 extends a15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> b;
    public String c;
    public long d;
    public NewWriteModel e;
    public z25 f;
    public y25 g;
    public NewWriteModel.g h;
    public String i;
    public n17 j;
    public WriteImagesInfo k;
    public ImageModel l;
    public String m;
    public NewWriteModel.g n;
    public AntiHelper.k o;
    public final a9 p;

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l17 a;

        public a(l17 l17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l17Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ey4 ey4Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ey4Var, writeData, antiData}) == null) {
                if (this.a.h != null) {
                    this.a.h.callback(z, postWriteCallBackData, ey4Var, writeData, antiData);
                }
                if (z) {
                    this.a.c = null;
                    this.a.B(true);
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (z) {
                    this.a.e.setWriteData(null);
                    this.a.e.i0(false);
                    this.a.k.clear();
                    this.a.j();
                    this.a.a().A(new w05(2, 10, null));
                } else if (i != 230277 && i != 230278 && i != 340016 && i != 1990032 && !AntiHelper.m(i, str)) {
                    if (ey4Var != null && writeData != null && !StringUtils.isNull(ey4Var.c())) {
                        writeData.setVcodeMD5(ey4Var.b());
                        writeData.setVcodeUrl(ey4Var.c());
                        writeData.setVcodeExtra(ey4Var.a());
                        if (je5.b(ey4Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getContext().getPageActivity(), 12006, writeData, false, ey4Var.d())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getContext().getPageActivity(), writeData, 12006)));
                        }
                    } else if (postWriteCallBackData != null && i == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.b.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    } else if (i == 238010 || xq8.d(i)) {
                    } else {
                        this.a.getContext().showToast(str);
                    }
                } else {
                    this.a.J(i, str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(l17 l17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(l17 l17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l17 a;

        public d(l17 l17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l17Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.a.e.i0(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements cj8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l17 a;

        public e(l17 l17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l17Var;
        }

        @Override // com.repackage.cj8.f
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            if (writeData.getWriteImagesInfo() != null && this.a.k.size() == 0) {
                this.a.k.copyFrom(writeData.getWriteImagesInfo());
                if (this.a.k != null && this.a.k.getChosedFiles() != null && this.a.k.getChosedFiles().size() > 0) {
                    EditorTools a = this.a.a();
                    a.A(new w05(2, 10, this.a.k.getChosedFiles().size() + ""));
                }
            }
            if (this.a.k == null || this.a.k.size() == 0) {
                this.a.a().A(new w05(2, 10, null));
            }
            if (li.isEmpty(writeData.getContent()) || !li.isEmpty(this.a.c)) {
                return;
            }
            this.a.c = writeData.getContent();
            l17 l17Var = this.a;
            l17Var.C(l17Var.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l17(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = "";
        this.i = null;
        this.k = new WriteImagesInfo();
        this.l = null;
        this.n = new a(this);
        this.o = new b(this);
        this.p = new d(this);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || a() == null) {
            return;
        }
        a().A(new w05(13, -1, null));
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || a() == null) {
            return;
        }
        a().A(new w05(9, -1, Boolean.valueOf(z)));
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || a() == null) {
            return;
        }
        a().A(new w05(6, 29, str));
    }

    public void D(y25 y25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, y25Var) == null) {
            this.g = y25Var;
        }
    }

    public void E(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    public void F(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.h = gVar;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.c = str;
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public void I(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.d = j;
        }
    }

    public void J(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                if (AntiHelper.w(this.b.getPageActivity(), str, i, this.o) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i != 230277 && i != 230278) {
                getContext().showToast(str);
            } else {
                K(str);
            }
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            nr4 nr4Var = new nr4(getContext().getPageActivity());
            nr4Var.setMessage(str);
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0988, new c(this));
            nr4Var.create(getContext()).show();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            H(true);
            a().j();
        }
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.b : (TbPageContext) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            cj8.y(String.valueOf(this.d), null);
        }
    }

    public final void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            p(intent, true);
        }
    }

    public final void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
            this.m = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.m;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, mi.d(this.b.getPageActivity(), mi.k(this.b.getPageActivity())), mi.d(this.b.getPageActivity(), mi.i(this.b.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.m, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception unused) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.k.addChooseFile(imageFileInfo);
            this.k.updateQuality();
            if (this.k.getChosedFiles() != null) {
                s();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            cj8.p(String.valueOf(this.d), new e(this));
        }
    }

    public n17 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.j == null && a() != null) {
                this.j = (n17) a().n(29);
            }
            return this.j;
        }
        return (n17) invokeV.objValue;
    }

    public final void o(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            p(intent, false);
        }
    }

    public final void p(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048595, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.k.parseJson(stringExtra);
        this.k.updateQuality();
        if (this.k.getChosedFiles() != null) {
            s();
        }
    }

    public WriteImagesInfo q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.k : (WriteImagesInfo) invokeV.objValue;
    }

    public long r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.d : invokeV.longValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!WriteActivityConfig.isAsyncWriting() || this.d <= 0) {
                WriteActivityConfig.newInstance(this.b.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.d)).setFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL).setCallFrom("1").setContent(this.c).setWriteImagesInfo(this.k).send();
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            H(false);
            a().o();
        }
    }

    public void u(BaseActivity baseActivity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048600, this, baseActivity, bundle) == null) || baseActivity == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(baseActivity);
        this.e = newWriteModel;
        newWriteModel.n0(this.n);
        ImageModel imageModel = new ImageModel(baseActivity.getPageContext());
        this.l = imageModel;
        imageModel.setLoadDataCallBack(this.p);
        if (bundle != null) {
            this.k.parseJson(bundle.getString("write_images"));
            this.m = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        WriteImagesInfo writeImagesInfo = this.k;
        if (writeImagesInfo != null) {
            writeImagesInfo.setMaxImagesAllowed(9);
        }
        WriteImagesInfo writeImagesInfo2 = this.k;
        if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.k.getChosedFiles().size() <= 0) {
            return;
        }
        EditorTools a2 = a();
        a2.A(new w05(2, 10, this.k.getChosedFiles().size() + ""));
    }

    public void v(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048601, this, i, i2, intent) == null) {
            PostWriteCallBackData postWriteCallBackData2 = null;
            if (i2 != -1) {
                if (i2 == 0 && i == 12006) {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData2 = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData3 = postWriteCallBackData2;
                    NewWriteModel.g gVar = this.h;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData3, null, this.e.b0(), null);
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData4 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.h != null) {
                    this.c = null;
                    B(true);
                    this.e.setWriteData(null);
                    this.e.i0(false);
                    this.k.clear();
                    j();
                    a().A(new w05(2, 10, null));
                    this.h.callback(true, postWriteCallBackData4, null, this.e.b0(), null);
                }
            } else if (i == 12012) {
                o(intent);
            } else if (i == 13003) {
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e2) {
                        BdLog.e(e2);
                        postWriteCallBackData = null;
                    }
                    this.n.callback(true, postWriteCallBackData, null, null, null);
                }
            } else if (i == 24007) {
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    statisticItem.param("obj_locate", 6);
                    if (shareItem != null) {
                        statisticItem.param("tid", shareItem.M);
                    }
                    statisticItem.param("pid", intent.getStringExtra("pid"));
                    TiebaStatic.log(statisticItem);
                }
            } else if (i == 12009 || i == 12010) {
                if (i == 12010) {
                    l(intent);
                }
            } else {
                switch (i) {
                    case TaskResponseData.ERROR_NO_TASK_OFFLINE_03 /* 12002 */:
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
                            A();
                            this.e.i0(false);
                            return;
                        }
                        this.l.D(intent.getStringExtra("file_name"));
                        return;
                    case 12004:
                        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                            return;
                        }
                        z(parcelableArrayListExtra);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.e.cancelLoadData();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.e.b0() == null) {
                this.e.setWriteData(new WriteData());
            }
            if (this.e.b0() == null) {
                return;
            }
            this.e.b0().setForumId("0");
            this.e.b0().setType(9);
            this.e.b0().setEntranceType(1);
            this.e.b0().setCanNoForum(true);
            this.e.b0().setTransmitForumData("[]");
            this.e.b0().setCallFrom("1");
            this.e.b0().setTopicId(String.valueOf(this.d));
            this.e.b0().setContent(this.c);
            this.e.b0().setIsNoTitle(true);
            this.e.b0().setTitle("");
            this.e.b0().setVoice(null);
            this.e.b0().setVoiceDuringTime(-1);
            if (!this.e.Y()) {
                getContext().showToast((int) R.string.obfuscated_res_0x7f0f15b3);
                return;
            }
            y25 y25Var = this.g;
            if (y25Var == null || !y25Var.a()) {
                z25 z25Var = this.f;
                if (z25Var != null) {
                    z25Var.a();
                }
                if (!this.e.r0()) {
                }
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            WriteData writeData = new WriteData(2);
            writeData.setContent(this.c);
            writeData.setTopicId(String.valueOf(this.d));
            writeData.setWriteImagesInfo(this.k);
            cj8.y(String.valueOf(this.d), writeData);
        }
    }

    public final void z(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, arrayList) == null) || a() == null) {
            return;
        }
        a().A(new w05(17, 29, arrayList));
    }
}
