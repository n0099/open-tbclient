package com.sina.weibo.sdk.network;

import com.sina.weibo.sdk.network.base.RequestResult;
import com.sina.weibo.sdk.network.exception.RequestException;
import com.sina.weibo.sdk.network.target.Target;
/* loaded from: classes8.dex */
public interface IRequestService {
    RequestCancelable asyncRequest(IRequestParam iRequestParam, Target target);

    RequestResult request(IRequestParam iRequestParam) throws RequestException;

    Object request(IRequestParam iRequestParam, Class cls) throws RequestException;
}
