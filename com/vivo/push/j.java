package com.vivo.push;

import android.os.Handler;
import android.text.TextUtils;
import com.vivo.push.LocalAliasTagsManager;
import com.vivo.push.cache.ISubscribeAppAliasManager;
import com.vivo.push.cache.ISubscribeAppTagManager;
import com.vivo.push.model.SubscribeAppInfo;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UnvarnishedMessage f13947a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager.LocalMessageCallback f13948b;
    final /* synthetic */ LocalAliasTagsManager c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LocalAliasTagsManager localAliasTagsManager, UnvarnishedMessage unvarnishedMessage, LocalAliasTagsManager.LocalMessageCallback localMessageCallback) {
        this.c = localAliasTagsManager;
        this.f13947a = unvarnishedMessage;
        this.f13948b = localMessageCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        ISubscribeAppTagManager iSubscribeAppTagManager;
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        int targetType = this.f13947a.getTargetType();
        String tragetContent = this.f13947a.getTragetContent();
        if (!TextUtils.isEmpty(tragetContent) && targetType != 0) {
            switch (targetType) {
                case 3:
                    iSubscribeAppAliasManager = this.c.mSubscribeAppAliasManager;
                    SubscribeAppInfo subscribeAppInfo = iSubscribeAppAliasManager.getSubscribeAppInfo();
                    if (subscribeAppInfo == null || subscribeAppInfo.getTargetStatus() != 1 || !subscribeAppInfo.getName().equals(tragetContent)) {
                        p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, tragetContent);
                        com.vivo.push.util.p.a(LocalAliasTagsManager.TAG, tragetContent + " has ignored ; current Alias is " + subscribeAppInfo);
                        return;
                    }
                    break;
                case 4:
                    iSubscribeAppTagManager = this.c.mSubscribeAppTagManager;
                    List<String> subscribeTags = iSubscribeAppTagManager.getSubscribeTags();
                    if (subscribeTags == null || !subscribeTags.contains(tragetContent)) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(tragetContent);
                        p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, arrayList);
                        com.vivo.push.util.p.a(LocalAliasTagsManager.TAG, tragetContent + " has ignored ; current tags is " + subscribeTags);
                        return;
                    }
                    break;
            }
        }
        handler = this.c.mHandler;
        handler.post(new k(this));
    }
}
