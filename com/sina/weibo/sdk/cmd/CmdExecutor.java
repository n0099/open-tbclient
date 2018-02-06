package com.sina.weibo.sdk.cmd;

import com.sina.weibo.sdk.cmd.BaseCmd;
/* loaded from: classes3.dex */
interface CmdExecutor<T extends BaseCmd> {
    boolean doExecutor(T t);
}
