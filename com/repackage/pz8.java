package com.repackage;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.repackage.dr4;
import java.io.File;
/* loaded from: classes6.dex */
public class pz8 implements ps8, Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public VideoFileInfo b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public AlbumVideoCompressingDialogView g;
    public VideoConvertUtil h;
    public Handler i;
    public wl7 j;
    public boolean k;
    public final CustomMessageListener l;

    /* loaded from: classes6.dex */
    public class a implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(pz8 pz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pz8 pz8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                Intent intent = new Intent();
                intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                this.a.a.setResult(-1, intent);
                this.a.a.finish();
            }
        }
    }

    public pz8(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.f = false;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, am7.class);
        am7 am7Var = runTask != null ? (am7) runTask.getData() : null;
        if (am7Var != null) {
            this.j = am7Var.get();
        }
        wl7 wl7Var = this.j;
        if (wl7Var != null) {
            wl7Var.g();
        }
        this.l = new b(this, 2001374);
        this.a = baseFragmentActivity;
        VideoConvertUtil videoConvertUtil = new VideoConvertUtil(baseFragmentActivity);
        this.h = videoConvertUtil;
        videoConvertUtil.o(this);
        this.i = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.l);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0082 -> B:25:0x0085). Please submit an issue!!! */
    public static VideoFileInfo e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                VideoFileInfo videoFileInfo = new VideoFileInfo();
                videoFileInfo.videoPath = str;
                videoFileInfo.lastModified = file.lastModified();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            videoFileInfo.videoDuration = mg.e(mediaMetadataRetriever.extractMetadata(9), 0);
                            videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                            videoFileInfo.videoWidth = mg.e(mediaMetadataRetriever.extractMetadata(18), 0);
                            videoFileInfo.videoHeight = mg.e(mediaMetadataRetriever.extractMetadata(19), 0);
                            int e = mg.e(mediaMetadataRetriever.extractMetadata(24), 0);
                            if (e == 90 || e == 270) {
                                int i = videoFileInfo.videoWidth;
                                videoFileInfo.videoWidth = videoFileInfo.videoHeight;
                                videoFileInfo.videoHeight = i;
                            }
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            mediaMetadataRetriever.release();
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return videoFileInfo;
            }
            return null;
        }
        return (VideoFileInfo) invokeL.objValue;
    }

    @Override // com.repackage.ps8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.i.sendEmptyMessage(2);
        }
    }

    @Override // com.repackage.ps8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            VideoConvertUtil videoConvertUtil = this.h;
            if (videoConvertUtil != null) {
                videoConvertUtil.a();
            }
            this.f = true;
            if (this.c != null) {
                File file = new File(this.c);
                if (file.exists()) {
                    file.delete();
                }
            }
            h();
            this.c = null;
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.a.showLoadingDialog(null);
            VideoFileInfo e = e(this.c);
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.c);
            videoInfo.setVideoDuration(e.videoDuration / 1000);
            videoInfo.setVideoWidth(e.videoWidth);
            videoInfo.setVideoHeight(e.videoHeight);
            videoInfo.setVideoLength(new File(e.videoPath).length());
            videoInfo.setVideoSource(2);
            videoInfo.setIsCompressedVideo(z);
            TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(this.a);
            tbFileVideoActivityConfig.getIntent().putExtras(this.a.getIntent());
            tbFileVideoActivityConfig.setFrom(1);
            tbFileVideoActivityConfig.setVideoInfo(videoInfo);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
            if (WorkPublishManager.isWorkPublishLocate()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 2).param("obj_source", WorkPublishManager.isWorkPublishLocateVideoCenter() ? 2 : 1));
            }
            this.e = false;
            this.c = null;
            wl7 wl7Var = this.j;
            if (wl7Var != null) {
                wl7Var.d();
            }
        }
    }

    public void g(VideoFileInfo videoFileInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, videoFileInfo, str, str2) == null) {
            this.b = videoFileInfo;
            if (videoFileInfo == null || this.a == null) {
                return;
            }
            if (videoFileInfo.videoDuration > 600000) {
                s();
                return;
            }
            VideoConvertUtil videoConvertUtil = this.h;
            if (videoConvertUtil == null || !videoConvertUtil.n()) {
                String str3 = this.b.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    oi.M(this.a, R.string.obfuscated_res_0x7f0f0b1f);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                    n(107);
                } else if (!new File(str3).exists()) {
                    oi.M(this.a, R.string.obfuscated_res_0x7f0f0b1f);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                    n(106);
                } else {
                    VideoFileInfo videoFileInfo2 = this.b;
                    if (videoFileInfo2 != null) {
                        this.c = videoFileInfo2.videoPath;
                        f(false);
                        n(102);
                    }
                }
            }
        }
    }

    public final void h() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (relativeLayout = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091641)) == null || this.g.getParent() == null) {
            return;
        }
        relativeLayout.removeView(this.g);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
            this.i.removeMessages(5);
            int i = message.what;
            if (i == 1) {
                this.i.removeMessages(1);
                AlbumVideoCompressingDialogView albumVideoCompressingDialogView = this.g;
                if (albumVideoCompressingDialogView != null && albumVideoCompressingDialogView.b()) {
                    this.g.setPercent(message.arg1);
                }
                Handler handler = this.i;
                handler.sendMessageDelayed(handler.obtainMessage(5), 60000L);
            } else if (i == 2) {
                if (!this.f) {
                    oi.M(this.a, R.string.obfuscated_res_0x7f0f0b1c);
                    n(103);
                }
                this.k = false;
                this.e = false;
                h();
            } else if (i == 3) {
                this.k = false;
                this.e = true;
                if (!StringUtils.isNull(this.c)) {
                    File file = new File(this.c);
                    this.c = this.c.replace("_tiebaconverting.mp4", DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                    file.renameTo(new File(this.c));
                }
                h();
                if (!this.d) {
                    f(true);
                    wl7 wl7Var = this.j;
                    if (wl7Var != null) {
                        wl7Var.d();
                    }
                }
            } else if (i == 4) {
                this.k = false;
                this.e = false;
                h();
                n(104);
            } else if (i == 5) {
                this.k = false;
                oi.M(this.a, R.string.obfuscated_res_0x7f0f0b1c);
                VideoConvertUtil videoConvertUtil = this.h;
                if (videoConvertUtil != null && videoConvertUtil.n()) {
                    d();
                }
                n(105);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            VideoConvertUtil videoConvertUtil = this.h;
            if (videoConvertUtil != null) {
                videoConvertUtil.l();
            }
            Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(5);
            }
            wl7 wl7Var = this.j;
            if (wl7Var != null) {
                wl7Var.k("album");
            }
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.e && !TextUtils.isEmpty(this.c) && new File(this.c).exists()) {
                f(true);
                n(101);
            }
            wl7 wl7Var = this.j;
            if (wl7Var != null) {
                wl7Var.e("album");
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d = false;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d = true;
            this.a.closeLoadingDialog();
        }
    }

    public final void n(int i) {
        wl7 wl7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (wl7Var = this.j) == null) {
            return;
        }
        wl7Var.i(i, "album");
    }

    public void o(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, antiData, postPrefixData, str, str2) == null) {
        }
    }

    @Override // com.repackage.ps8
    public void onConvertAborted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i.sendEmptyMessage(4);
        }
    }

    @Override // com.repackage.ps8
    public void onConvertFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.i.sendEmptyMessage(2);
        }
    }

    @Override // com.repackage.ps8
    public void onConvertProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            this.i.sendMessage(obtain);
        }
    }

    @Override // com.repackage.ps8
    public void onConvertSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.i.sendEmptyMessage(3);
        }
    }

    public void p(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, frsTabInfoData) == null) {
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            dr4 positiveButton = new dr4(this.a).setTitle(R.string.obfuscated_res_0x7f0f0b1e).setPositiveButton(R.string.obfuscated_res_0x7f0f07d8, new a(this));
            positiveButton.create(this.a.getPageContext());
            positiveButton.setCanceledOnTouchOutside(false);
            positiveButton.show();
        }
    }
}
