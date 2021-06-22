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
/* loaded from: classes7.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnvarnishedMessage f40417a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager.LocalMessageCallback f40418b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40419c;

    public j(LocalAliasTagsManager localAliasTagsManager, UnvarnishedMessage unvarnishedMessage, LocalAliasTagsManager.LocalMessageCallback localMessageCallback) {
        this.f40419c = localAliasTagsManager;
        this.f40417a = unvarnishedMessage;
        this.f40418b = localMessageCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        ISubscribeAppTagManager iSubscribeAppTagManager;
        int targetType = this.f40417a.getTargetType();
        String tragetContent = this.f40417a.getTragetContent();
        if (!TextUtils.isEmpty(tragetContent) && targetType != 0) {
            if (targetType == 3) {
                iSubscribeAppAliasManager = this.f40419c.mSubscribeAppAliasManager;
                SubscribeAppInfo subscribeAppInfo = iSubscribeAppAliasManager.getSubscribeAppInfo();
                if (subscribeAppInfo == null || subscribeAppInfo.getTargetStatus() != 1 || !subscribeAppInfo.getName().equals(tragetContent)) {
                    p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, tragetContent);
                    com.vivo.push.util.p.a(LocalAliasTagsManager.TAG, tragetContent + " has ignored ; current Alias is " + subscribeAppInfo);
                    return;
                }
            } else if (targetType == 4) {
                iSubscribeAppTagManager = this.f40419c.mSubscribeAppTagManager;
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
        handler = this.f40419c.mHandler;
        handler.post(new k(this));
    }
}
