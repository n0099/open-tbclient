package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.vivo.push.cache.ISubscribeAppAliasManager;
import com.vivo.push.cache.ISubscribeAppTagManager;
import com.vivo.push.cache.impl.SubscribeAppAliasManagerImpl;
import com.vivo.push.model.SubscribeAppInfo;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class LocalAliasTagsManager {
    public static final String DEFAULT_LOCAL_REQUEST_ID = "push_cache_sp";
    public static volatile LocalAliasTagsManager mLocalAliasTagsManager;
    public Context mContext;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public ISubscribeAppAliasManager mSubscribeAppAliasManager;
    public ISubscribeAppTagManager mSubscribeAppTagManager;
    public static final String TAG = "LocalAliasTagsManager";
    public static final ExecutorService WORK_POOL = com.vivo.push.util.e.a(TAG);
    public static final Object SLOCK = new Object();

    /* loaded from: classes6.dex */
    public interface LocalMessageCallback {
        boolean onNotificationMessageArrived(Context context, UPSNotificationMessage uPSNotificationMessage);

        void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage);
    }

    public LocalAliasTagsManager(Context context) {
        this.mContext = context;
        this.mSubscribeAppTagManager = new com.vivo.push.cache.impl.b(context);
        this.mSubscribeAppAliasManager = new SubscribeAppAliasManagerImpl(context);
    }

    public static final LocalAliasTagsManager getInstance(Context context) {
        if (mLocalAliasTagsManager == null) {
            synchronized (SLOCK) {
                if (mLocalAliasTagsManager == null) {
                    mLocalAliasTagsManager = new LocalAliasTagsManager(context.getApplicationContext());
                }
            }
        }
        return mLocalAliasTagsManager;
    }

    public void delLocalAlias(String str) {
        WORK_POOL.execute(new h(this, str));
    }

    public void delLocalTags(ArrayList<String> arrayList) {
        WORK_POOL.execute(new i(this, arrayList));
    }

    public String getLocalAlias() {
        SubscribeAppInfo subscribeAppInfo = this.mSubscribeAppAliasManager.getSubscribeAppInfo();
        if (subscribeAppInfo != null) {
            return subscribeAppInfo.getName();
        }
        return null;
    }

    public List<String> getLocalTags() {
        return this.mSubscribeAppTagManager.getSubscribeTags();
    }

    public void init() {
        WORK_POOL.execute(new g(this));
    }

    public void onDelAlias(List<String> list, String str) {
        if (DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new l(this, list));
        }
    }

    public void onDelTags(List<String> list, String str) {
        if (DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new m(this, list));
        }
    }

    public void onReceiverMsg(UnvarnishedMessage unvarnishedMessage, LocalMessageCallback localMessageCallback) {
        WORK_POOL.execute(new j(this, unvarnishedMessage, localMessageCallback));
    }

    public boolean onReceiverNotification(UPSNotificationMessage uPSNotificationMessage, LocalMessageCallback localMessageCallback) {
        List<String> subscribeTags;
        int targetType = uPSNotificationMessage.getTargetType();
        String tragetContent = uPSNotificationMessage.getTragetContent();
        if (targetType != 3) {
            if (targetType == 4 && ((subscribeTags = this.mSubscribeAppTagManager.getSubscribeTags()) == null || !subscribeTags.contains(tragetContent))) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(tragetContent);
                p.a().b(DEFAULT_LOCAL_REQUEST_ID, arrayList);
                com.vivo.push.util.p.a(TAG, tragetContent + " has ignored ; current tags is " + subscribeTags);
                return true;
            }
        } else {
            SubscribeAppInfo subscribeAppInfo = this.mSubscribeAppAliasManager.getSubscribeAppInfo();
            if (subscribeAppInfo == null || subscribeAppInfo.getTargetStatus() != 1 || !subscribeAppInfo.getName().equals(tragetContent)) {
                p.a().b(DEFAULT_LOCAL_REQUEST_ID, tragetContent);
                com.vivo.push.util.p.a(TAG, tragetContent + " has ignored ; current Alias is " + subscribeAppInfo);
                return true;
            }
        }
        return localMessageCallback.onNotificationMessageArrived(this.mContext, uPSNotificationMessage);
    }

    public void onSetAlias(List<String> list, String str) {
        if (DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new n(this, list));
        }
    }

    public void onSetTags(List<String> list, String str) {
        if (DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new e(this, list));
        }
    }

    public void setLocalAlias(String str) {
        WORK_POOL.execute(new d(this, str));
    }

    public void setLocalTags(ArrayList<String> arrayList) {
        WORK_POOL.execute(new f(this, arrayList));
    }

    public void setSubscribeAppAliasManager(ISubscribeAppAliasManager iSubscribeAppAliasManager) {
        this.mSubscribeAppAliasManager = iSubscribeAppAliasManager;
    }

    public void setSubscribeAppTagManager(ISubscribeAppTagManager iSubscribeAppTagManager) {
        this.mSubscribeAppTagManager = iSubscribeAppTagManager;
    }
}
