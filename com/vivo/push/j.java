package com.vivo.push;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.LocalAliasTagsManager;
import com.vivo.push.cache.ISubscribeAppAliasManager;
import com.vivo.push.cache.ISubscribeAppTagManager;
import com.vivo.push.model.SubscribeAppInfo;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnvarnishedMessage f42160a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager.LocalMessageCallback f42161b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f42162c;

    public j(LocalAliasTagsManager localAliasTagsManager, UnvarnishedMessage unvarnishedMessage, LocalAliasTagsManager.LocalMessageCallback localMessageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {localAliasTagsManager, unvarnishedMessage, localMessageCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42162c = localAliasTagsManager;
        this.f42160a = unvarnishedMessage;
        this.f42161b = localMessageCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        ISubscribeAppTagManager iSubscribeAppTagManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int targetType = this.f42160a.getTargetType();
            String tragetContent = this.f42160a.getTragetContent();
            if (!TextUtils.isEmpty(tragetContent) && targetType != 0) {
                if (targetType == 3) {
                    iSubscribeAppAliasManager = this.f42162c.mSubscribeAppAliasManager;
                    SubscribeAppInfo subscribeAppInfo = iSubscribeAppAliasManager.getSubscribeAppInfo();
                    if (subscribeAppInfo == null || subscribeAppInfo.getTargetStatus() != 1 || !subscribeAppInfo.getName().equals(tragetContent)) {
                        p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, tragetContent);
                        com.vivo.push.util.p.a(LocalAliasTagsManager.TAG, tragetContent + " has ignored ; current Alias is " + subscribeAppInfo);
                        return;
                    }
                } else if (targetType == 4) {
                    iSubscribeAppTagManager = this.f42162c.mSubscribeAppTagManager;
                    List<String> subscribeTags = iSubscribeAppTagManager.getSubscribeTags();
                    if (subscribeTags == null || !subscribeTags.contains(tragetContent)) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(tragetContent);
                        p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, arrayList);
                        com.vivo.push.util.p.a(LocalAliasTagsManager.TAG, tragetContent + " has ignored ; current tags is " + subscribeTags);
                        return;
                    }
                }
            }
            handler = this.f42162c.mHandler;
            handler.post(new k(this));
        }
    }
}
