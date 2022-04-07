package com.repackage;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.RecAppDownloadReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RemoteViews a;

    /* loaded from: classes6.dex */
    public class a extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jb8 a;

        public a(jb8 jb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jb8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) || this.a.a == null || foVar == null || foVar.p() == null) {
                return;
            }
            this.a.a.setImageViewBitmap(R.id.obfuscated_res_0x7f090290, foVar.p());
        }
    }

    public jb8(DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadData, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), (int) R.layout.obfuscated_res_0x7f0d0244);
        b(i);
        this.a.setTextViewText(R.id.obfuscated_res_0x7f090832, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cb7));
        this.a.setImageViewResource(R.id.obfuscated_res_0x7f090820, R.drawable.obfuscated_res_0x7f080e51);
        this.a.setImageViewResource(R.id.obfuscated_res_0x7f090823, R.drawable.obfuscated_res_0x7f080e4f);
        this.a.setTextViewText(R.id.obfuscated_res_0x7f09081e, downloadData.getUser_name());
        ig.h().m(downloadData.getApp_icon(), 17, new a(this), BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.a.setOnClickPendingIntent(R.id.obfuscated_res_0x7f090820, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.a.setOnClickPendingIntent(R.id.obfuscated_res_0x7f090823, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public void b(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i > 0) {
                str = i + "%";
            } else {
                str = "0%";
            }
            this.a.setProgressBar(R.id.obfuscated_res_0x7f090830, 100, i, false);
            this.a.setTextViewText(R.id.obfuscated_res_0x7f090831, str);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.setTextViewText(R.id.obfuscated_res_0x7f090832, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0504));
            this.a.setImageViewResource(R.id.obfuscated_res_0x7f090820, R.drawable.obfuscated_res_0x7f080e52);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setTextViewText(R.id.obfuscated_res_0x7f090832, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cb7));
            this.a.setImageViewResource(R.id.obfuscated_res_0x7f090820, R.drawable.obfuscated_res_0x7f080e51);
        }
    }
}
