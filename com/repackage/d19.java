package com.repackage;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.tieba.write.write.WriteImageGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c19;
/* loaded from: classes6.dex */
public class d19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<WriteActivity> a;
    public WriteImageGridView b;
    public WriteImagesInfo c;
    public c19 d;
    public l55 e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public c19.f j;

    /* loaded from: classes6.dex */
    public class a implements c19.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d19 a;

        public a(d19 d19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d19Var;
        }

        @Override // com.repackage.c19.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.a.getPageActivity(), this.a.c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.a.g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.a.f);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            if (this.a.a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(false);
                albumFloatActivityConfig.setCanSelectOnlyVideo(false);
                albumFloatActivityConfig.setCanEditImage(false);
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) this.a.a.getPageActivity()).e;
                antiData.setIfVoice(((WriteActivity) this.a.a.getPageActivity()).Z0);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) this.a.a.getPageActivity()).r.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) this.a.a.getPageActivity()).d, ((WriteActivity) this.a.a.getPageActivity()).r.getFirstDir(), ((WriteActivity) this.a.a.getPageActivity()).r.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // com.repackage.c19.f
        public void b(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.c == null || (count = ListUtils.getCount(this.a.c.getChosedFiles())) == 0 || i < 0 || i >= count || (imageInfoAt = this.a.c.getImageInfoAt(i)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.a.a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.a.getPageActivity(), 12012, this.a.c, i)));
        }

        @Override // com.repackage.c19.f
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a.c == null || this.a.c.getChosedFiles() == null || i < 0 || i >= this.a.c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.a.c.getChosedFiles().remove(i);
            if (remove.isTempFile()) {
                vb.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            d19 d19Var = this.a;
            d19Var.d.g(d19Var.c);
            this.a.d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.a.c.getChosedFiles()) && this.a.a.getOrignalPage() != null) {
                ((WriteActivity) this.a.a.getOrignalPage()).C2();
                ((WriteActivity) this.a.a.getOrignalPage()).F4(false);
                if (!this.a.h) {
                    this.a.b.setVisibility(8);
                }
            }
            if (this.a.a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.a.a.getPageActivity()).C6();
                ((WriteActivity) this.a.a.getPageActivity()).H6();
            }
        }
    }

    public d19(TbPageContext<WriteActivity> tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new l55();
        this.f = AlbumActivityConfig.FROM_WRITE;
        this.g = "";
        this.h = false;
        this.j = new a(this);
        this.a = tbPageContext;
        this.b = (WriteImageGridView) view2.findViewById(R.id.obfuscated_res_0x7f09264a);
        c19 c19Var = new c19(view2.getContext(), this.e, null, this.j);
        this.d = c19Var;
        this.b.setAdapter((ListAdapter) c19Var);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.b();
        }
    }

    public GridView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (GridView) invokeV.objValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.h = z;
            this.d.f(z);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.i = z;
            n();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.d.h(z);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.d.i(z);
        }
    }

    public void m(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, writeImagesInfo, str, str2) == null) {
            this.f = str;
            this.g = str2;
            this.c = writeImagesInfo;
            this.d.g(writeImagesInfo);
            this.d.notifyDataSetChanged();
            n();
        }
    }

    public final void n() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.h) {
                this.b.setVisibility(0);
            } else if (!this.i && (writeImagesInfo = this.c) != null && writeImagesInfo.getChosedFiles() != null) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
        }
    }
}
