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
import com.repackage.my8;
/* loaded from: classes6.dex */
public class ny8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<WriteActivity> a;
    public WriteImageGridView b;
    public WriteImagesInfo c;
    public my8 d;
    public p45 e;
    public String f;
    public String g;
    public boolean h;
    public my8.f i;

    /* loaded from: classes6.dex */
    public class a implements my8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny8 a;

        public a(ny8 ny8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny8Var;
        }

        @Override // com.repackage.my8.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.c == null || this.a.c.getChosedFiles() == null || i < 0 || i >= this.a.c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.a.c.getChosedFiles().remove(i);
            if (remove.isTempFile()) {
                ub.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            ny8 ny8Var = this.a;
            ny8Var.d.f(ny8Var.c);
            this.a.d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.a.c.getChosedFiles()) && this.a.a.getOrignalPage() != null) {
                ((WriteActivity) this.a.a.getOrignalPage()).D2();
                ((WriteActivity) this.a.a.getOrignalPage()).F4(false);
                this.a.b.setVisibility(8);
            }
            if (this.a.a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.a.a.getPageActivity()).C6();
                ((WriteActivity) this.a.a.getPageActivity()).H6();
            }
        }

        @Override // com.repackage.my8.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.c == null) {
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
                antiData.setIfVoice(((WriteActivity) this.a.a.getPageActivity()).b1);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) this.a.a.getPageActivity()).v.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) this.a.a.getPageActivity()).d, ((WriteActivity) this.a.a.getPageActivity()).v.getFirstDir(), ((WriteActivity) this.a.a.getPageActivity()).v.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // com.repackage.my8.f
        public void c(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a.c == null || (count = ListUtils.getCount(this.a.c.getChosedFiles())) == 0 || i < 0 || i >= count || (imageInfoAt = this.a.c.getImageInfoAt(i)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.a.a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.a.getPageActivity(), 12012, this.a.c, i)));
        }
    }

    public ny8(TbPageContext<WriteActivity> tbPageContext, View view2) {
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
        this.e = new p45();
        this.f = AlbumActivityConfig.FROM_WRITE;
        this.g = "";
        this.i = new a(this);
        this.a = tbPageContext;
        this.b = (WriteImageGridView) view2.findViewById(R.id.obfuscated_res_0x7f092524);
        my8 my8Var = new my8(view2.getContext(), this.e, null, this.i);
        this.d = my8Var;
        this.b.setAdapter((ListAdapter) my8Var);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.b();
        }
    }

    public GridView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (GridView) invokeV.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.h = z;
            l();
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.d.g(z);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.d.h(z);
        }
    }

    public void k(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, writeImagesInfo, str, str2) == null) {
            this.f = str;
            this.g = str2;
            this.c = writeImagesInfo;
            this.d.f(writeImagesInfo);
            this.d.notifyDataSetChanged();
            l();
        }
    }

    public final void l() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!this.h && (writeImagesInfo = this.c) != null && writeImagesInfo.getChosedFiles() != null) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
        }
    }
}
