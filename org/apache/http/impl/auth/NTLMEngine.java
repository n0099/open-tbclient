package org.apache.http.impl.auth;
@Deprecated
/* loaded from: classes8.dex */
public interface NTLMEngine {
    String generateType1Msg(String str, String str2) throws NTLMEngineException;

    String generateType3Msg(String str, String str2, String str3, String str4, String str5) throws NTLMEngineException;
}
