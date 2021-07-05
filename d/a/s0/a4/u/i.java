package d.a.s0.a4.u;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
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
import com.kwai.video.player.PlayerPostEvent;
import d.a.s0.a4.u.h;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f57675a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f57676b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f57677c;

    /* renamed from: d  reason: collision with root package name */
    public h f57678d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.b0.b f57679e;

    /* renamed from: f  reason: collision with root package name */
    public String f57680f;

    /* renamed from: g  reason: collision with root package name */
    public String f57681g;

    /* renamed from: h  reason: collision with root package name */
    public h.f f57682h;

    /* loaded from: classes9.dex */
    public class a implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f57683a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57683a = iVar;
        }

        @Override // d.a.s0.a4.u.h.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f57683a.f57677c == null || this.f57683a.f57677c.getChosedFiles() == null || i2 < 0 || i2 >= this.f57683a.f57677c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.f57683a.f57677c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                d.a.c.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = this.f57683a;
            iVar.f57678d.f(iVar.f57677c);
            this.f57683a.f57678d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.f57683a.f57677c.getChosedFiles()) && this.f57683a.f57675a.getOrignalPage() != null) {
                ((WriteActivity) this.f57683a.f57675a.getOrignalPage()).refreshPostButton();
            }
            if (this.f57683a.f57675a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.f57683a.f57675a.getPageActivity()).refreshImageLauncher();
                ((WriteActivity) this.f57683a.f57675a.getPageActivity()).refreshVideoLauncher();
            }
        }

        @Override // d.a.s0.a4.u.h.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f57683a.f57677c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f57683a.f57675a.getPageActivity(), this.f57683a.f57677c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f57683a.f57681g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.f57683a.f57680f);
            albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            if (this.f57683a.f57675a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(false);
                albumFloatActivityConfig.setCanSelectOnlyVideo(false);
                albumFloatActivityConfig.setCanEditImage(false);
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) this.f57683a.f57675a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) this.f57683a.f57675a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) this.f57683a.f57675a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) this.f57683a.f57675a.getPageActivity()).mPrefixData, ((WriteActivity) this.f57683a.f57675a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) this.f57683a.f57675a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // d.a.s0.a4.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f57683a.f57677c == null || (count = ListUtils.getCount(this.f57683a.f57677c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = this.f57683a.f57677c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.f57683a.f57675a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f57683a.f57675a.getPageActivity(), 12012, this.f57683a.f57677c, i2)));
        }
    }

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57679e = new d.a.r0.b0.b();
        this.f57680f = AlbumActivityConfig.FROM_WRITE;
        this.f57681g = "";
        this.f57682h = new a(this);
        this.f57675a = tbPageContext;
        this.f57676b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f57679e, null, this.f57682h);
        this.f57678d = hVar;
        this.f57676b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57679e.b();
        }
    }

    public GridView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57676b : (GridView) invokeV.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f57678d.g(z);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f57678d.h(z);
        }
    }

    public void i(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, writeImagesInfo, str, str2) == null) {
            this.f57680f = str;
            this.f57681g = str2;
            this.f57677c = writeImagesInfo;
            this.f57678d.f(writeImagesInfo);
            this.f57678d.notifyDataSetChanged();
        }
    }
}
