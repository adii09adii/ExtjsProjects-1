Ext.Loader.setConfig({
    enabled: true
 });
Ext.application({
    name: 'Demo',
    appFolder: 'WebRoot',
    controllers: ['Controller'],
    autoCreateViewport: true
});