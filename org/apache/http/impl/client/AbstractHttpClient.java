package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
@Deprecated
/* loaded from: classes2.dex */
public abstract class AbstractHttpClient implements HttpClient {
    public abstract AuthSchemeRegistry createAuthSchemeRegistry();

    public abstract ClientConnectionManager createClientConnectionManager();

    public abstract ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy();

    public abstract ConnectionReuseStrategy createConnectionReuseStrategy();

    public abstract CookieSpecRegistry createCookieSpecRegistry();

    public abstract CookieStore createCookieStore();

    public abstract CredentialsProvider createCredentialsProvider();

    public abstract HttpContext createHttpContext();

    public abstract HttpParams createHttpParams();

    public abstract BasicHttpProcessor createHttpProcessor();

    public abstract HttpRequestRetryHandler createHttpRequestRetryHandler();

    public abstract HttpRoutePlanner createHttpRoutePlanner();

    public abstract AuthenticationHandler createProxyAuthenticationHandler();

    public abstract RedirectHandler createRedirectHandler();

    public abstract HttpRequestExecutor createRequestExecutor();

    public abstract AuthenticationHandler createTargetAuthenticationHandler();

    public abstract UserTokenHandler createUserTokenHandler();

    public AbstractHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        throw new RuntimeException("Stub!");
    }

    public HttpParams determineParams(HttpRequest httpRequest) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    public synchronized HttpRequestInterceptor getRequestInterceptor(int i) {
        throw new RuntimeException("Stub!");
    }

    public synchronized HttpResponseInterceptor getResponseInterceptor(int i) {
        throw new RuntimeException("Stub!");
    }

    public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> cls) {
        throw new RuntimeException("Stub!");
    }

    public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> cls) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setAuthSchemes(AuthSchemeRegistry authSchemeRegistry) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setCookieSpecs(CookieSpecRegistry cookieSpecRegistry) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setCookieStore(CookieStore cookieStore) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setHttpRequestRetryHandler(HttpRequestRetryHandler httpRequestRetryHandler) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setParams(HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setProxyAuthenticationHandler(AuthenticationHandler authenticationHandler) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setRedirectHandler(RedirectHandler redirectHandler) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setRoutePlanner(HttpRoutePlanner httpRoutePlanner) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setTargetAuthenticationHandler(AuthenticationHandler authenticationHandler) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setUserTokenHandler(UserTokenHandler userTokenHandler) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void clearRequestInterceptors() {
        throw new RuntimeException("Stub!");
    }

    public synchronized void clearResponseInterceptors() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized AuthSchemeRegistry getAuthSchemes() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public final synchronized ClientConnectionManager getConnectionManager() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized ConnectionReuseStrategy getConnectionReuseStrategy() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized CookieSpecRegistry getCookieSpecs() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized CookieStore getCookieStore() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized CredentialsProvider getCredentialsProvider() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized BasicHttpProcessor getHttpProcessor() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized HttpRequestRetryHandler getHttpRequestRetryHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public final synchronized HttpParams getParams() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized AuthenticationHandler getProxyAuthenticationHandler() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized RedirectHandler getRedirectHandler() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized HttpRequestExecutor getRequestExecutor() {
        throw new RuntimeException("Stub!");
    }

    public synchronized int getRequestInterceptorCount() {
        throw new RuntimeException("Stub!");
    }

    public synchronized int getResponseInterceptorCount() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized HttpRoutePlanner getRoutePlanner() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized AuthenticationHandler getTargetAuthenticationHandler() {
        throw new RuntimeException("Stub!");
    }

    public final synchronized UserTokenHandler getUserTokenHandler() {
        throw new RuntimeException("Stub!");
    }

    public RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }
}
